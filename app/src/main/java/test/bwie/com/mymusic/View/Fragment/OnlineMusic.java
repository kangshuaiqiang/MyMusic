package test.bwie.com.mymusic.View.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import test.bwie.com.mymusic.Model.Bean.MusicList;
import test.bwie.com.mymusic.Model.Bean.MusicListChild;
import test.bwie.com.mymusic.Presenter.Persen.HomePersent;
import test.bwie.com.mymusic.Presenter.interfaces.GetBeanP_V;
import test.bwie.com.mymusic.R;
import test.bwie.com.mymusic.View.Adapter.OlineRecyclerAdapter;

/**
 * Created by 黑白 on 2017/9/28.
 * 在线音乐
 */

public class OnlineMusic extends BaseFragment {

    private RecyclerView recyclerView;
    private List<MusicListChild> musicListChildren = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getActivity(), R.layout.online, null);
        recyclerView = v.findViewById(R.id.recyclerVeiw);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        initDate();
        return v;
    }

    private void initDate() {
        String[] title = getResources().getStringArray(R.array.music_title);
        String[] type = getResources().getStringArray(R.array.musiclist_type);
        for (int i = 0; i < title.length; i++) {
            MusicListChild musicListChild = new MusicListChild();
            musicListChild.setType(type[i]);
            musicListChild.setListName(title[i]);
            musicListChildren.add(musicListChild);
        }
        recyclerView.setAdapter(new OlineRecyclerAdapter(musicListChildren, getActivity(), new HomePersent()));

    }

}
