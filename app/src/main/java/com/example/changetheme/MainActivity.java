package com.example.changetheme;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.module_dynamic.DynamicMain;
import com.example.module_dynamic.QDSkinManager;
import com.qmuiteam.qmui.skin.QMUISkinLayoutInflaterFactory;
import com.qmuiteam.qmui.skin.QMUISkinManager;

public class MainActivity extends AppCompatActivity {
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
//                if(skinIndex + 1 > 3){
                    fragmentJump(DynamicMain.class);
//                    skinIndex = 0;
//                }
//                skinIndex += 1;
//                QDSkinManager.changeSkin(skinIndex);
            }
        });
    }

    private void fragmentJump(Class<?> aClass) {
        FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
        try {
            ft.replace(R.id.fl_container, (Fragment) aClass.newInstance());
            ft.commitAllowingStateLoss();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
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
