package com.rt3.rtsystem.utils;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by RT3
 * on 2017/8/2.
 */

public class OkhttpUtils {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    public static OkHttpClient mClient = new OkHttpClient();


    /**
     * post请求
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public static String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = mClient.newCall(request).execute();
        return response.body().string();
    }

}
