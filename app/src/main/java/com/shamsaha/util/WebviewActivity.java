package com.shamsaha.util;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.shamsaha.R;

public class WebviewActivity extends AppCompatActivity {
    private String key = "";
    private String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        key = getIntent().getStringExtra("key");
        url = getIntent().getStringExtra("url");
        if(key.equals(UtilFunction.sstKey)){

        }


        final ProgressDialog pd = ProgressDialog.show(WebviewActivity.this, "Loading", "Please wait, Shamasaha loading in process...", true);
        WebView mWebview  = (WebView)findViewById(R.id.webview);
        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript
        mWebview.getSettings().setLoadWithOverviewMode(true);
        mWebview.getSettings().setUseWideViewPort(true);
        mWebview.getSettings().setBuiltInZoomControls(true);

        mWebview.setWebViewClient(new WebViewClient() {

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(WebviewActivity.this, description, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pd.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                pd.dismiss();
                String webUrl = mWebview.getUrl();
            }

        });

        mWebview .loadUrl(url);

    }
}