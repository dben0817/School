package com.example.dben0.class8webview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    WebView myweb;
    ProgressBar mypb;
    EditText address;
    Button goBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myweb = findViewById(R.id.wv);
        mypb = findViewById(R.id.pb);
        address = findViewById(R.id.address);
        goBtn = findViewById(R.id.goBtn);

        myweb.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//
//                return false;   //this is outdated
//            }
        });

        myweb.getSettings().setJavaScriptEnabled(true);

        myweb.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int progress) {
                if (progress ==100) {
                    mypb.setVisibility(view.GONE);
                }
                else
                    {
                    mypb.setVisibility(view.VISIBLE);
                }
            }
        });
        myweb.loadUrl("https://www.google.com");
        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = address.getText().toString();
                if(url.equals("")) url="google.com";
                myweb.loadUrl("http://www."+url);

                InputMethodManager imm = (InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);

                if (imm!=null)
                {imm.toggleSoftInput(InputMethodManager.HIDE_NOT_ALWAYS, 0);}
            }
        });


    }


}
