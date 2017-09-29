package test.bwie.com.mymusic.Model.OkHttp;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import test.bwie.com.mymusic.Presenter.interfaces.GetBeanM_P;

/**
 * Created by 黑白 on 2017/9/28.
 */

public class OkHttpUtils<C> {

    private final OkHttpClient okHttpClient;
    private Gson gson;
    private GetBeanM_P getBeanMP;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            C c = (C) msg.obj;
            getBeanMP.Succeed(c);
        }
    };

    public void initGetBeanM_P(GetBeanM_P getBeanMP) {
        this.getBeanMP = getBeanMP;
    }

    public OkHttpUtils() {
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .build();
        gson = new Gson();
    }

    /**
     * 网络请求 GetHead方法
     */
    public void getHead(String url, Map<String, String> map, final Class<C> clazz) {
       /* Request.Builder request = new Request.Builder();
        request.url(url);
        request.get();*/
        StringBuilder builder = new StringBuilder(url);
        for (Map.Entry<String, String> ent : map.entrySet()) {
//            request.addHeader(ent.getKey(), ent.getValue());
            builder.append("&" + ent.getKey() + "=" + ent.getValue());
        }
        Log.d("zzz", builder.toString());
        Request request = new Request.Builder()
                .url(builder.toString())
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            //失败
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("zzzzzz", "错误" + call.toString() + e.getLocalizedMessage());
            }

            //成功
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                toHandler(string, clazz);
            }
        });

    }

    /**
     * 网络请求 Get方法
     */
    public <C> void get(String url, final Class<C> clazz) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            //失败
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("zzzzzz", "错误" + call.toString() + e.getLocalizedMessage());
            }

            //成功
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.d("zzz", string);

             /*   C c = gson.fromJson(string, clazz);
                Message message = handler.obtainMessage();
                message.obj = c;
                handler.sendMessage(message);*/
                toHandler(string, clazz);
            }
        });

    }

    public void post(String url, Map<String, String> map, final Class<C> clazz) {
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> ent : map.entrySet()) {
            builder.add(ent.getKey(), ent.getValue());
        }
        Request request = new Request.Builder()
                .post(builder.build())
                .url(url)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("zzzzzz", "错误" + call.toString() + e.getLocalizedMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                toHandler(response, clazz);
            }
        });
    }

    private void toHandler(String str, Class clazz) throws IOException {
//        String s = response.body().string();
        C c = (C) gson.fromJson(str, clazz);
        Message message = handler.obtainMessage();
        message.obj = c;
        handler.sendMessage(message);
    }

}
