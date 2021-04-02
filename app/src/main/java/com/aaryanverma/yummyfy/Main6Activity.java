package com.aaryanverma.yummyfy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Main6Activity extends AppCompatActivity {
WebView w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        w=(WebView)findViewById(R.id.web);
        w.loadUrl("https://www.zomato.com");
    }
}
