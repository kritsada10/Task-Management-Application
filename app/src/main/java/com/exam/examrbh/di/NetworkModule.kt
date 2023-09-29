package com.exam.examrbh.di

import com.exam.examrbh.BuildConfig
import com.exam.examrbh.data.service.EndpointAPI
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitBuilder(): Retrofit.Builder = Retrofit.Builder()

    @Provides
    @Singleton
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder = OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)


    @Provides
    @Singleton
    fun provideConverterFactory(): Converter.Factory = GsonConverterFactory.create(GsonBuilder().create())

    @Provides
    @Singleton
    fun provideApi(builder: Retrofit.Builder, okHttpClientBuilder: OkHttpClient.Builder, converterFactory: Converter.Factory, interceptor: ApiInterceptor): EndpointAPI {

        /*val interceptor = Interceptor()*/
        okHttpClientBuilder.addInterceptor(interceptor)
        val client = okHttpClientBuilder.build()
        return builder.client(client)
            .baseUrl(BuildConfig.API_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(nullOnEmptyConverterFactory)
            .addConverterFactory(converterFactory)
            .build()
            .create(EndpointAPI::class.java)
    }

    private val nullOnEmptyConverterFactory = object : Converter.Factory() {
        fun converterFactory() = this
        override fun responseBodyConverter(type: Type, annotations: Array<out Annotation>, retrofit: Retrofit) =
            object : Converter<ResponseBody, Any?> {
                val nextResponseBodyConverter = retrofit.nextResponseBodyConverter<Any?>(converterFactory(), type, annotations)

                override fun convert(value: ResponseBody) =
                    if (value.contentLength() != 0L) nextResponseBodyConverter.convert(value) else null
            }
    }

}