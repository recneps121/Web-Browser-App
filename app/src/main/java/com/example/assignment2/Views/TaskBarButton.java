package com.example.assignment2.Views;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatButton;

public class TaskBarButton extends AppCompatButton {

    public TaskBarButton(Context context, String text){
        super(context);

        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
            100,
            LinearLayout.LayoutParams.MATCH_PARENT
        );

        buttonParams.weight = 0;
        setLayoutParams(buttonParams);
        setText(text);
        setTextColor(Color.BLACK);
    }
}
