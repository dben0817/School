package com.example.cis.class6colorlist;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView myTV = findViewById(R.id.hex);
        ImageView myIV = findViewById(R.id.sample);
        TextView sColor = findViewById(R.id.selColor);

        Intent dIntent = getIntent();
        String str = dIntent.getStringExtra("clrNum");

        myTV.setText(str);

        int num = dIntent.getIntExtra("clrImg", 0);
        myTV.setTextColor(Color.parseColor(str));

        myIV.setImageResource(num);

        sColor.setBackgroundColor(Color.parseColor(str));

    }
}
