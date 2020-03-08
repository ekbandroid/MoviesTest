package androidekb.com.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface AppCoroutineDispatchers {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val computation: CoroutineDispatcher
}

class DefaultAppCoroutineDispatchers(
    override val io: CoroutineDispatcher = Dispatchers.IO,
    override val main: CoroutineDispatcher = Dispatchers.Main.immediate,
    override val computation: CoroutineDispatcher = Dispatchers.Default
) : AppCoroutineDispatchers