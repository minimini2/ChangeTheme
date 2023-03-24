package com.example.changetheme;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.core.view.LayoutInflaterCompat;

import com.qmuiteam.qmui.skin.QMUISkinLayoutInflaterFactory;
import com.qmuiteam.qmui.skin.QMUISkinManager;

public class MainActivity extends Activity {
    private QMUISkinManager skinManager;
    private Button btn;
    private int skinIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 使用 QMUISkinLayoutInflaterFactory
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        LayoutInflaterCompat.setFactory2(layoutInflater, new QMUISkinLayoutInflaterFactory(this, layoutInflater));

        super.onCreate(savedInstanceState);

        // 注入 QMUISkinManager
        skinManager = QMUISkinManager.defaultInstance(this);

        setContentView(R.layout.activity_main);

        initView();
        initEvent();
    }

    private void initView(){
        btn = findViewById(R.id.btn);
    }

    private void initEvent(){
        //换肤操作
        skinIndex = QDSkinManager.SKIN_DEFAULT;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(skinIndex + 1 > 3){
                    skinIndex = 0;
                }
                skinIndex += 1;
                QDSkinManager.changeSkin(skinIndex);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
        //注册QDSkinManager
        if(skinManager != null){
            skinManager.register(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        //取消注册QDSkinManager
        if(skinManager != null){
            skinManager.unRegister(this);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
