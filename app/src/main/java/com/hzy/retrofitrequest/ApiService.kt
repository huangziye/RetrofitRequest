package com.hzy.retrofitrequest

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET

/**
 *
 * @author: ziye_huang
 * @date: 2019/3/1
 */
interface ApiService {

    @GET("api/today")
    fun getData(): Observable<ResponseBody>

}