package test.bwie.com.mymusic.View.Activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import test.bwie.com.mymusic.R;
import test.bwie.com.mymusic.View.Adapter.MyHomeViewpagerAdapter;
import test.bwie.com.mymusic.View.Fragment.MyMusic;
import test.bwie.com.mymusic.View.Fragment.OnlineMusic;

/**
 * 主界面
 */
public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mFunction;
    private TabLayout mTab;
    private ImageView mSearch;
    private ViewPager mViewPager;
    private ImageView mSinggeriamge;
    /**
     * musicNamse
     */
    private TextView mMusicName;
    /**
     * Sinnger
     */
    private TextView mSingger;
    private ImageView mSuspend;
    private ImageView mNext;
    private LinearLayout mMusicplay;

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private String[] tabname = {"我的音乐", "在线音乐"};
    private NavigationView navigationView;
    private DrawerLayout drawerLayout1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initTablayout();
        initFragemnts();
    }



    private void initFragemnts() {
        fragments.add(new MyMusic());
        fragments.add(new OnlineMusic());
        mViewPager.setAdapter(new MyHomeViewpagerAdapter(getSupportFragmentManager(), fragments, tabname));
        mTab.setupWithViewPager(mViewPager);
    }

    private void initTablayout() {
        mTab.addTab(mTab.newTab().setText(tabname[0]));
        mTab.addTab(mTab.newTab().setText(tabname[1]));
    }


    private void initView() {
        mFunction = (ImageView) findViewById(R.id.function);
        mFunction.setOnClickListener(this);
        mTab = (TabLayout) findViewById(R.id.tab);
        mSearch = (ImageView) findViewById(R.id.search);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mSinggeriamge = (ImageView) findViewById(R.id.singgeriamge);
        mMusicName = (TextView) findViewById(R.id.musicName);
        mSingger = (TextView) findViewById(R.id.singger);
        mSuspend = (ImageView) findViewById(R.id.suspend);
        mSuspend.setOnClickListener(this);
        mNext = (ImageView) findViewById(R.id.next);
        mNext.setOnClickListener(this);
        mMusicplay = (LinearLayout) findViewById(R.id.musicplay);
        mMusicplay.setOnClickListener(this);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        drawerLayout1 = (DrawerLayout) findViewById(R.id.drawer);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.suspend:
                break;
            case R.id.next:
                break;
            case R.id.musicplay:
                break;
            case R.id.function:
                drawerLayout1.openDrawer(GravityCompat.START);
                break;
        }
    }

}
