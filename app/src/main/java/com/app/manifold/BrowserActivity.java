package com.app.manifold;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.app.manifold.R;

public class BrowserActivity extends AppCompatActivity {
    Button b1;
    WebView wb;
    EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        e1 = findViewById(R.id.type_url);
        b1 = findViewById(R.id.button_search);
        wb = (WebView)findViewById(R.id.webView);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wb.loadUrl(e1.getText().toString().trim());
            }
        });

    }
}