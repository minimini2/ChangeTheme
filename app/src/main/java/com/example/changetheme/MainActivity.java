package com.example.changetheme;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.lib_skin.SkinManager;

public class MainActivity extends AppCompatActivity {

    private AppCompatTextView mTvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatButton btn = this.findViewById(R.id.btn);
        mTvInfo = this.findViewById(R.id.tv_show);
        btn.setOnClickListener(v -> {
            SkinManager.getInstance().loadSkin(Config.getPath(this,1), this);//Config.getPath(this):获取到的是皮肤包保存路径
            setInfoState();//在textview上面显示当前皮肤状态。后期可以删除
            notifyChanged();
        });
    }

//    private void fragmentJump(Class<?> aClass) {
//        FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
//        try {
//            ft.replace(R.id.fl_container, (Fragment) aClass.newInstance());
//            ft.commitAllowingStateLoss();
//        } catch (IllegalAccessException | InstantiationException e) {
//            e.printStackTrace();
//        }
//    }

    public void setInfoState() {
        setInfoState(SkinManager.getInstance().getState());
    }

    public void setInfoState(SkinManager.State state) {
        mTvInfo.setText(String.format("当前皮肤状态:%s", state.name()));
    }
    /// 点击回调监听
    protected void notifyChanged() {
    }

    @Override
    protected void onPause() {
        super.onPause();
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
