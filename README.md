[![](https://jitpack.io/v/huangziye/RetrofitRequest.svg)](https://jitpack.io/#huangziye/RetrofitRequest)

### 添加 `RetrofitRequest` 到项目

- 第一步： 添加 `JitPack` 到项目的根 `build.gradle` 中


```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

- 第二步：添加库依赖


```gradle
dependencies {
    implementation 'com.github.huangziye:RetrofitRequest:${latest_version}'
}
```




<br />

### 使用方式

```
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
```






<br />

### 关于我


- [简书](https://user-gold-cdn.xitu.io/2018/7/26/164d5709442f7342)

- [掘金](https://juejin.im/user/5ad93382518825671547306b)

- [Github](https://github.com/huangziye)

<br />

### License

```
Copyright 2018, huangziye

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```

