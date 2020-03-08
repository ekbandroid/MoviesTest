package androidekb.com.moviestest.di

import android.content.Context
import androidekb.com.moviestest.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyStore
import java.security.SecureRandom
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager

object NetworkModule : InjectionModule {

    private const val DEFAULT_CONNECT_TIMEOUT_SECONDS = 15L
    private const val DEFAULT_READ_TIMEOUT_SECONDS = 15L

    override fun create(): Module = module {
        //        single {
//            GsonBuilder()
//                .applyIf(ConfigUtils.DEBUG) { setPrettyPrinting() }
//                .create()
//        }

        single {
            Retrofit.Builder()
                .baseUrl(BuildConfig.REST_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
              //  .client(get())
                .build()
        }

//        single {
//            val context = androidContext()
//            val trustFactory = createTrustManagerFactory(context)
//
//            val socketFactory = createSslContext(trustFactory).socketFactory
//            val trustManager = trustFactory.trustManagers[0] as X509TrustManager
//
//            val appLogger = get<Logger>()
//            val httpLogger = object : HttpLoggingInterceptor.Logger {
//                override fun log(message: String) {
//                    appLogger.d(message)
//                }
//            }
//
//            OkHttpClient.Builder()
//                .sslSocketFactory(socketFactory, trustManager)
//                .hostnameVerifier(HostnameVerifier { _, _ -> true })
//                .readTimeout(DEFAULT_CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
//                .connectTimeout(DEFAULT_READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
//                .addInterceptor(TokenInterceptor(TokenProvider(get())))
//                .addInterceptor(ServerErrorInterceptor(get()))
//                .applyIf(ConfigUtils.DEBUG) {
//                    addInterceptor(HttpLoggingInterceptor(httpLogger).apply {
//                        level = HttpLoggingInterceptor.Level.BODY
//                    })
//                }
//                .build()
//        }
    }
}