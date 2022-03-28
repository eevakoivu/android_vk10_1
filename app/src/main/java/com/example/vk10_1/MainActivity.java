package com.example.vk10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    WebView web;
    EditText editText;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = (WebView) findViewById(R.id.webView);
        editText = (EditText) findViewById(R.id.editText);

        web.setWebViewClient(new WebViewClient());
        web.loadUrl("http://www.lut.fi"); //https://www.google.fi/
        editText();
    }

    public void editText(){
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                /*if(keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER){
                    url = editText.getText().toString();
                    if(!url.isEmpty()){
                        web.loadUrl("http://"+url);
                    }
                    return true;
                }*/
                if(i == EditorInfo.IME_ACTION_GO){
                    url = editText.getText().toString();
                    if(!url.isEmpty()){
                        web.loadUrl("http://"+url);
                    }
                    return true;
                }
                return false;
            }
        });
    }
}