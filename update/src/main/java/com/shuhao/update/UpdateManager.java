package com.shuhao.update;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;

import okhttp3.Call;

import static android.content.ContentValues.TAG;

/**
 * Created by luke on 2017/8/23.
 */

public class UpdateManager {


    private DownloadInProgressLintener downloadInProgressLintener;

    private static UpdateManager instance;

    private boolean isOpenApk = false;

    private Context context;

    public static UpdateManager getInstance(Context context) {
        if (instance == null) {
            instance = new UpdateManager(context);
        }
        return instance;
    }

    private UpdateManager(Context context) {
        this.context = context;
    }

    public UpdateManager downloadApk(String url, final String apkName) {
        OkHttpUtils.get().url(url).build().execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), apkName) {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e(TAG, "downloadApk:" + e.getMessage());
            }

            @Override
            public void onResponse(File response, int id) {
                if (isOpenApk) {
                    openFile(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + apkName);
                }
                Log.e(TAG, "download succ");
            }

            @Override
            public void inProgress(float progress, long total, int id) {
                downloadInProgressLintener.inProgress((int) (100 * progress));
            }
        });
        return getInstance(context);
    }

    private UpdateManager openFile(String fileName) {
        File file = new File(fileName);
        // TODO Auto-generated method stub
        Log.e("OpenFile", file.getName());
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(android.content.Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file),
                "application/vnd.android.package-archive");
        context.startActivity(intent);
        return getInstance(context);
    }

    public UpdateManager isOpenApk(boolean isOpenApk) {
        this.isOpenApk = isOpenApk;
        return getInstance(context);
    }

    public UpdateManager setDownloadInProgessLintener(DownloadInProgressLintener downloadInProgessLintener) {
        this.downloadInProgressLintener = downloadInProgessLintener;
        return getInstance(context);
    }

    public interface DownloadInProgressLintener {
        void inProgress(int progress);
    }

}
