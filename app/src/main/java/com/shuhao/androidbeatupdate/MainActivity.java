package com.shuhao.androidbeatupdate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.shuhao.update.UpdateManager;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UpdateManager.getInstance(this).downloadApk("http://app.appyunpan.com//yyhmobile//yyhmobile-d.apk", "test.apk").isOpenApk(true).setDownloadInProgessLintener(new UpdateManager.DownloadLintener() {
            @Override
            public void inProgress(int progress) {

            }

            @Override
            public void OnSuccess(String succ) {

            }
        });
    }
}
