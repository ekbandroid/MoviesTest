package androidekb.com.moviestest.di

import androidekb.com.common.di.InjectionModule
import androidekb.com.common.coroutines.AppCoroutineDispatchers
import androidekb.com.common.coroutines.DefaultAppCoroutineDispatchers
import org.koin.core.module.Module
import org.koin.dsl.module

object AppModule : InjectionModule {
    override fun create(): Module = module {
        single<AppCoroutineDispatchers> { DefaultAppCoroutineDispatchers() }
    }
}