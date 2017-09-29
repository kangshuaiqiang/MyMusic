package test.bwie.com.mymusic.Presenter.Persen;

import test.bwie.com.mymusic.Model.OkHttp.OkHttpUtils;
import test.bwie.com.mymusic.Presenter.Api;
import test.bwie.com.mymusic.Presenter.interfaces.BaseInterface;

/**
 * Created by 黑白 on 2017/9/29.
 */

public class BasePresenter {
    OkHttpUtils okHttpUtils;
    Api api;

    public BasePresenter() {
        okHttpUtils = new OkHttpUtils();
        api = new Api();
    }
}
