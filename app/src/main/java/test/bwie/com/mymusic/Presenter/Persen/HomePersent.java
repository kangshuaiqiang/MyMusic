package test.bwie.com.mymusic.Presenter.Persen;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import test.bwie.com.mymusic.Model.Bean.MusicList;
import test.bwie.com.mymusic.Presenter.interfaces.GetBeanM_P;
import test.bwie.com.mymusic.Presenter.interfaces.GetBeanP_V;

/**
 * Created by 黑白 on 2017/9/29.
 */

public class HomePersent extends BasePresenter implements GetBeanM_P {


    public void initDatte(String type) {

        okHttpUtils.initGetBeanM_P(this);
        Map<String, String> map = new HashMap<>();
        map.put(api.METHOD, "baidu.ting.billboard.billList");
        map.put(api.TYPE, type);
        map.put(api.SIZE, "3");
        map.put(api.OFFSET, "0");
        okHttpUtils.getHead(api.HTTPURL, map, MusicList.class);

        /*okHttpUtils.initGetBeanM_P(new GetBeanM_P() {
            @Override
            public void Succeed(Object o) {

            }

            @Override
            public void Erroe(int errorCode, String errorMessger) {

            }
        });*/

    }

    private GetBeanP_V getBeanP_v;

    public void initGetBeanP_V(GetBeanP_V getBeanP_vs) {
        this.getBeanP_v = getBeanP_vs;
    }

    @Override
    public void Succeed(Object o) {

        MusicList musicList = (MusicList) o;
        Log.d("zzzz", musicList.getSong_list().get(0).getTitle());
        getBeanP_v.Succeed(o);
    }

    @Override
    public void Erroe(int errorCode, String errorMessger) {

    }
}
