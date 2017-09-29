package test.bwie.com.mymusic.View.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 黑白 on 2017/9/28.
 */

public class MyHomeViewpagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
    private String[] tabname;

    public MyHomeViewpagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments, String[] tabname) {
        super(fm);
        this.fragments = fragments;
        this.tabname = tabname;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }



    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabname[position];
    }
}
