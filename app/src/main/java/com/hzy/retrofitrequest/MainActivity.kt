package com.hzy.retrofitrequest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hzy.request.Request

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Request.Builder().get()

    }
}
