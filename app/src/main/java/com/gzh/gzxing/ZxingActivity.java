package com.gzh.gzxing;

import android.os.Bundle;
import android.view.View;

import com.gzh.zxinglibrary.QCodeActivity;

/**
 * @ClassName: ZxingActivity
 * @Description: 描述类的作用
 * @author: GZH
 */
public class ZxingActivity extends QCodeActivity {
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        initSetting();
    }

    /**
     * 初始化扫码设置
     */
    private void initSetting() {
        //设置文本内容
        mCaptureText.setText("将二维码放入框内，即可自动扫描");
        //设置扫描线
        mScanline.setImageResource(R.drawable.wx_scan_line);
        //设置四个角背景图
        mScanCropView.setBackgroundResource(R.drawable.qr_code_bg);
        //设置头部布局
        View inflate = View.inflate(this, R.layout.layout_title, null);
        inflate.findViewById(R.id.img_title_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTitleView.addView(inflate);
    }
}
