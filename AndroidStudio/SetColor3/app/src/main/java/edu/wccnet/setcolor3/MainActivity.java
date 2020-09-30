package edu.wccnet.setcolor3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    SeekBar greenSb, redSb, blueSb, alphaSb;

    TextView tv, greenTv, blueTv, redTv, alphaTv;
    Button setClr;
    int red = 100;
    int green = 100;
    int blue = 100;
    float alpha = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greenSb = findViewById(R.id.greenSB);
        blueSb = findViewById(R.id.blueSB);
        redSb = findViewById(R.id.redSB);
        alphaSb = findViewById(R.id.alphaSB);
        tv = findViewById(R.id.tv);
        setClr = findViewById(R.id.setClr);

        greenTv = findViewById(R.id.greenTV);
        redTv = findViewById(R.id.redTV);
        blueTv = findViewById(R.id.blueTV);
        alphaTv = findViewById(R.id.alphaTV);

        for(SeekBar sb: new SeekBar[]{greenSb, blueSb, redSb, alphaSb}) {
            sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    red = redSb.getProgress();
                    green = greenSb.getProgress();
                    blue = blueSb.getProgress();
                    alpha=alphaSb.getProgress()/255f;

                    redTv.setText(String.valueOf(red));
                    blueTv.setText(String.valueOf(blue));
                    greenTv.setText(String.valueOf(green));
                    alphaTv.setText(String.valueOf(alpha));
                    redTv.setText(String.valueOf(red));
                    blueTv.setText(String.valueOf(blue));
                    greenTv.setText(String.valueOf(green));
                    alphaTv.setText(String.valueOf(alpha));
                    tv.setBackgroundColor(Color.rgb(red, green, blue));
                    tv.setAlpha(alpha);
                    NumberFormat alphaPercent = NumberFormat.getPercentInstance();
                    String alphaStr = alphaPercent.format(alpha);
                    alphaTv.setText(alphaStr);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
        }
        setClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
}
