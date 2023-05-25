package com.example.changetheme;

import android.content.Context;
import android.os.Environment;

import java.io.File;

public class Config {

    // 文件
    private static String SKIN_PACK ;
    private static final String SKIN_THEME_DARK = "test-skin-debug.apk";
    private static final String SKIN_THEME1 = "test-skin-debug.apk";

    // 文件夹
    private static final String FOLDER_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;

    public static String PATH ;

    public static String getPath(Context context,int theme) {
        if (theme==1){
            PATH = FOLDER_PATH + SKIN_THEME1;
        }else {
            PATH = FOLDER_PATH + SKIN_THEME_DARK;
        }
        return PATH;
    }
}
