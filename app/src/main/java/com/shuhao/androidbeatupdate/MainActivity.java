package com.shuhao.androidbeatupdate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shuhao.update.UpdateManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UpdateManager.getInstance(this).downloadApk("http://app.appyunpan.com//yyhmobile//yyhmobile-d.apk","test.apk").isOpenApk(true);
    }
}
