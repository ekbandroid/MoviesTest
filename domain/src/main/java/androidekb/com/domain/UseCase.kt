package androidekb.com.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.withContext

abstract class UseCase<in P, R> {

    abstract val dispatcher: CoroutineDispatcher

    suspend operator fun invoke(parameters: P): R = withContext(dispatcher) {
        execute(parameters)
    }

    protected abstract suspend fun execute(parameters: P): R
}

abstract class SubjectUseCase<in P, R> : UseCase<P, Flow<R>>() {

    override suspend fun execute(parameters: P): Flow<R> =
        createObservable(parameters)

    protected abstract fun createObservable(params: P): Flow<R>
}

interface ObservableUseCase<T> {
    val dispatcher: CoroutineDispatcher
    fun observe(): Flow<T>
}

abstract class SuspendingWorkUseCase<in P, R> : ObservableUseCase<R> {
    private val channel = ConflatedBroadcastChannel<R>()

    suspend operator fun invoke(params: P) = channel.send(doWork(params))

    abstract suspend fun doWork(params: P): R

    override fun observe(): Flow<R> = channel.asFlow()
}