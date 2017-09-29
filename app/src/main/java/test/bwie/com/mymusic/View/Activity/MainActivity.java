package test.bwie.com.mymusic.View.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import test.bwie.com.mymusic.R;

/**
 * 进入界面
 */
public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private int i = 3;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (i == -1) {
                return;
            }
            if (i <= 0) {
                Countdown();
            } else {
                textView.setText(i + "s");
                i--;
                handler.sendEmptyMessageDelayed(0, 1000);
            }

        }
    };
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Countdown();
                i = -1;
                return;
            }
        });
    }

    private void initView() {
        textView = (TextView) findViewById(R.id.countdown);

        SharedPreferences countDown = getSharedPreferences("CountDown", MODE_PRIVATE);
        edit = countDown.edit();
        if (countDown.getBoolean("countdown", false)) {
            Countdown();
            return;
        }
        handler.sendEmptyMessage(0);
    }

    private void Countdown() {
        startActivity(new Intent(MainActivity.this, HomeActivity.class));
        edit.putBoolean("countdown", true);
        edit.commit();
//        handler.removeMessages(0);
        finish();
    }
}
