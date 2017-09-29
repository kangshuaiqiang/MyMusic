package test.bwie.com.mymusic.View.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import test.bwie.com.mymusic.R;
import test.bwie.com.mymusic.View.util.MyLinearLayou;

public class PlayListActivity extends AppCompatActivity {

    private ImageView mPlayheanImage;
    private RecyclerView mPlayrecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);
        String type = getIntent().getStringExtra("type");
        Toast.makeText(this, "" + type, Toast.LENGTH_SHORT).show();
        initView();
    }

    private void initView() {
        mPlayheanImage = (ImageView) findViewById(R.id.playheanImage);
        mPlayrecycler = (RecyclerView) findViewById(R.id.playrecycler);
        mPlayrecycler.setLayoutManager(new MyLinearLayou(this));
    }
}
