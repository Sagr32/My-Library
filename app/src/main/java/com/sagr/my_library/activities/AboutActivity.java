package com.sagr.my_library.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.sagr.my_library.R;

public class AboutActivity extends AppCompatActivity {


    public static String WEB_URL = "URL";
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        webView =(WebView) findViewById(R.id.webView);
        Intent intent = getIntent();
        if(intent !=null){
            webView.loadUrl(intent.getStringExtra(WEB_URL));
            webView.setWebViewClient(new WebViewClient());
            webView.getSettings().setJavaScriptEnabled(true);
        }

    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();

        }
    }
}