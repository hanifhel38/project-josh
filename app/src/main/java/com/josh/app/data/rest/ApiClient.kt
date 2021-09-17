package com.josh.app.data.rest

import com.josh.app.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class ApiClient {
    companion object{
        private val client = OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15,TimeUnit.SECONDS)
            .writeTimeout(15,TimeUnit.SECONDS)
            .build()
        private var retrofit: Retrofit? = null

        fun getClient(): Retrofit{
            if(retrofit==null){
                retrofit = Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
                    .client(client).build()
            }
            return retrofit!!
        }
    }
}