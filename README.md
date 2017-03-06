# GZxing
#图片缩放控件

![image](https://github.com/GuoZhiHao9396/GZxing/blob/master/app/src/main/res/raw/test.gif)

AndroidStudio使用Gradle构建添加依赖（推荐）

Add it in your root build.gradle at the end of repositories:
```java
     repositories {
        flatDir {
            dirs 'libs'
        }
     }

     dependencies {
	    compile 'com.google.zxing:core:3.3.0'
        compile (name:'gzxinglibrary-v1.0.0',ext:'aar')
     }
```

#使用介绍

1.创建Activity继承QCodeActivity
```java
    public class ZxingActivity extends QCodeActivity
```
2.设置相关属性
```java
   在ZxingActivity中

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
   //添加头部标题栏
   mTitleView.addView(inflate);
```
3.调用扫码
```java
   Intent in = new Intent(MainActivity.this, ZxingActivity.class);
   startActivityForResult(in, requestCode);

   //接收返回结果
   @Override
      protected void onActivityResult(int requestCode, int resultCode, Intent data) {
          super.onActivityResult(requestCode, resultCode, data);
          //扫描结果
          if (this.requestCode == requestCode && resultCode == RESULT_OK && data != null) {
              Toast.makeText(MainActivity.this, data.getStringExtra("url"), Toast.LENGTH_SHORT).show();
          }
      }
```
4.设置SDK最低版本
```text
   minSdkVersion 14
```
5.设置相关权限
```text
    <!--拍照权限-->
    <uses-permission android:name="android.permission.CAMERA"/>
    <!--震动权限-->
    <uses-permission android:name="android.permission.VIBRATE"/>
```

#License
```text
Copyright 2017 ZhiHao Guo

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
