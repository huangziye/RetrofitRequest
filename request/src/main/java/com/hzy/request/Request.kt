package com.hzy.request

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Request {

    class Builder {

        private var mBuilder: Retrofit.Builder = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(OkHttpClient())

        /**
         * 设置baseUrl
         */
        fun baseUrl(baseUrl: String): Builder {
            mBuilder.baseUrl(baseUrl)
            return this
        }

        fun addConverterFactory(factory: Converter.Factory): Builder {
            mBuilder.addConverterFactory(factory)
            return this
        }

        fun addCallAdapterFactory(factory: CallAdapter.Factory): Builder {
            mBuilder.addCallAdapterFactory(factory)
            return this
        }

        /**
         * 设置OkHttpClient
         */
        fun client(client: OkHttpClient): Builder {
            mBuilder.client(client)
            return this
        }

        /**
         * 返回IService对象或子类对象
         */
        fun <T> create(service: Class<T>): T {
            return mBuilder.build().create(service)
        }

    }

}