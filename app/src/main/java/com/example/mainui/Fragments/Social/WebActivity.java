package com.example.mainui.Fragments.Social;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mainui.R;

public class WebActivity extends AppCompatActivity {

    WebView web_view;

    @Override
    public void onBackPressed() {
        if(web_view.canGoBack()){
            web_view.goBack();
        }
        else{
            super.onBackPressed();
        }

    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web2);

        web_view = findViewById(R.id.web_view);

        Intent intent = getIntent();
        String website = intent.getStringExtra("links");

        web_view.setWebViewClient(new WebViewClient());
        web_view.loadUrl(website);

        WebSettings webSettings = web_view.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
}