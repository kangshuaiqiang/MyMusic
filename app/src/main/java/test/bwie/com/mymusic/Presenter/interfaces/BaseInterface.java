package test.bwie.com.mymusic.Presenter.interfaces;

/**
 * Created by 黑白 on 2017/9/29.
 */

public interface BaseInterface<C> {
    void Succeed(C c);

    void Erroe(int errorCode, String errorMessger);
}
