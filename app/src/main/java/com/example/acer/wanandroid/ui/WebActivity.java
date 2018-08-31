package com.example.acer.wanandroid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.webkit.WebView;

import com.example.acer.wanandroid.R;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        WebView webView = findViewById(R.id.webview);
        Intent intent = getIntent();

        if (intent != null) {
            String link = intent.getStringExtra("link");
            if (!TextUtils.isEmpty(link)) {
                webView.loadUrl(link);
            }
        }

    }
}
