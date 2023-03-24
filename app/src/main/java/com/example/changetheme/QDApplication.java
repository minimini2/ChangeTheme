package com.example.changetheme;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import androidx.annotation.NonNull;

//APP加载QDSkinManager并适配深色模式
public class QDApplication extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        QDSkinManager.install(this);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //适配 Dark Mode
        if ((newConfig.uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES) {
            QDSkinManager.changeSkin(QDSkinManager.SKIN_2);
        } else if (QDSkinManager.getCurrentSkin() == QDSkinManager.SKIN_2) {
            QDSkinManager.changeSkin(QDSkinManager.SKIN_DEFAULT);
        }
    }
}

