package com.example.assignment2.Views;

import android.content.Context;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatEditText;

public class AddressBar extends AppCompatEditText {

    public AddressBar(Context context) {
        super(context);

        LinearLayout.LayoutParams addressBarParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        addressBarParams.weight = 10;
        setLayoutParams(addressBarParams);
    }
}
