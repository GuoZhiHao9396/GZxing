package com.gzh.gzxing;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gzh.gpermissionslibrary.GPermissionsUtils;
import com.gzh.gpermissionslibrary.IGPermissions;

public class MainActivity extends Activity implements IGPermissions {
    //
    private final int requestCode = 10086;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 跳转扫码界面
     *
     * @param v
     */
    public void testOnClick(View v) {
        GPermissionsUtils.requestPermission(this, new String[]{Manifest.permission.CAMERA}, 0, false);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //扫描结果
        if (this.requestCode == requestCode && resultCode == RESULT_OK && data != null) {
            Toast.makeText(MainActivity.this, data.getStringExtra("url"), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void rationale(int i) {

    }

    @Override
    public void permissionFail(int i) {
        Toast.makeText(MainActivity.this, "未获取相机拍照权限", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void permissionSuccess(int i) {
        Intent in = new Intent(MainActivity.this, ZxingActivity.class);
        startActivityForResult(in, requestCode);
    }
}
