package com.example.module_dynamic;

import android.content.Context;
import android.content.res.Configuration;

import com.qmuiteam.qmui.skin.QMUISkinManager;

//换肤管理类
public class QDSkinManager {
    public static final int SKIN_DEFAULT = 1;
    public static final int SKIN_1 = 2;
    public static final int SKIN_2 = 3;
    private static Context context1;

    public static void install(Context context) {
        QMUISkinManager skinManager = QMUISkinManager.defaultInstance(context);
        skinManager.addSkin(SKIN_DEFAULT, R.style.AppTheme);
        skinManager.addSkin(SKIN_1, R.style.app_skin_1);
        skinManager.addSkin(SKIN_2, R.style.app_skin_2);

        boolean isDarkMode = (context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES;
        int storeSkinIndex = QDPreferenceManager.getInstance(context).getSkinIndex();
        if (isDarkMode && storeSkinIndex != SKIN_2) {
            skinManager.changeSkin(SKIN_2);
        } else if (!isDarkMode && storeSkinIndex == SKIN_1) {
            skinManager.changeSkin(SKIN_1);
        }else{
            skinManager.changeSkin(storeSkinIndex);
        }
    }

    public static void changeSkin(Context context,int index) {
        context1 = context;
        QMUISkinManager.defaultInstance(context).changeSkin(index);
        QDPreferenceManager.getInstance(context).setSkinIndex(index);
    }

    public static int getCurrentSkin() {
        return QMUISkinManager.defaultInstance(context1).getCurrentSkin();
    }
}

