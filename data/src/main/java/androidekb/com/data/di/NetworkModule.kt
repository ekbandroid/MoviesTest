package androidekb.com.data.di

import androidekb.com.common.di.InjectionModule
import androidekb.com.moviestest.data.BuildConfig
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule : InjectionModule {

    override fun create(): Module = module {
        single {
            Retrofit.Builder()
                .baseUrl(BuildConfig.REST_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}