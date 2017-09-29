package test.bwie.com.mymusic.View.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import test.bwie.com.mymusic.Presenter.Persen.BasePresenter;
import test.bwie.com.mymusic.Presenter.Persen.HomePersent;
import test.bwie.com.mymusic.R;

public class BaseActivity extends AppCompatActivity {

    public BasePresenter basePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
