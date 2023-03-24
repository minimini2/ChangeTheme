package com.example.module_dynamic;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.qmuiteam.qmui.skin.QMUISkinManager;

public class DynamicMain extends Fragment {
    private QMUISkinManager skinManager;
    private Button btn;
    private int skinIndex;
    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QDSkinManager.install(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dynamic_main,container,false);
        skinManager = QMUISkinManager.defaultInstance(view.getContext());
        btn = view.findViewById(R.id.btn);
        initEvent();
        return view;
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
                QDSkinManager.changeSkin(view.getContext(),skinIndex);
            }
        });
    }
}