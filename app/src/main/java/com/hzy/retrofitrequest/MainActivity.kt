package com.hzy.retrofitrequest

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hzy.request.Request
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_load_data.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val apiService = Request.Builder().baseUrl("http://gank.io/").create(ApiService::class.java)
        apiService.getData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ResponseBody> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: ResponseBody) {
                    Toast.makeText(this@MainActivity, t.string(), Toast.LENGTH_SHORT).show()
                }

                override fun onError(e: Throwable) {
                    if (e is HttpException) {
                        val body = e.response().errorBody()
                        val result = body?.string()
                        Toast.makeText(this@MainActivity, result, Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
                    }
                }
            })
    }
}
