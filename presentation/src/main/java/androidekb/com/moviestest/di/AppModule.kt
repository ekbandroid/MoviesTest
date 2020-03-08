package androidekb.com.moviestest.di

import androidekb.com.domain.AppCoroutineDispatchers
import androidekb.com.domain.DefaultAppCoroutineDispatchers
import org.koin.core.module.Module
import org.koin.dsl.module

object AppModule : InjectionModule {
    override fun create(): Module = module {
        single<AppCoroutineDispatchers> { DefaultAppCoroutineDispatchers() }
    }
}