/*
Written by Spencer R. Hall
Please give credit where credit is due.
 */

package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.Manifest.permission;

import com.example.assignment2.Views.AddressBar;
import com.example.assignment2.Views.TaskBarButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout taskBarLayout = new LinearLayout(this);
        taskBarLayout.setOrientation(LinearLayout.HORIZONTAL);

        final LinkedList history = new LinkedList();

        getSupportActionBar().hide();

        TaskBarButton back = new TaskBarButton(this, "B");
        TaskBarButton forward = new TaskBarButton(this, "F");
        final AddressBar addressBar = new AddressBar(this);
        TaskBarButton go = new TaskBarButton(this, "G");
        go.setBackgroundColor(Color.GREEN);

        final WebView contentView = new WebView(this);
        contentView.setWebViewClient(new WebViewClient());

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentView.loadUrl(addressBar.getText().toString());
                history.add(addressBar.getText().toString());
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (history.hasPrevious()) {
                    contentView.loadUrl(history.previous().toString());
                }
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (history.hasNext()) {
                    contentView.loadUrl(history.next().toString());
                }
            }
        });


        taskBarLayout.addView(back);
        taskBarLayout.addView(forward);
        taskBarLayout.addView(addressBar);
        taskBarLayout.addView(go);

        mainLayout.addView(taskBarLayout);
        mainLayout.addView(contentView);

        setContentView(mainLayout);

    }
}