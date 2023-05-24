package com.example.changetheme;

import android.app.Application;

import com.example.lib_skin.SkinManager;

public class SkinApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SkinManager.init(this);
    }
}
