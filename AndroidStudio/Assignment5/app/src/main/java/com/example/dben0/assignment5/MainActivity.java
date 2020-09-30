package com.example.dben0.assignment5;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox bgCheck, textCheck;

    SeekBar redP, greenP, blueP;
    TextView bgT, textT, redT, greenT, blueT,display;
    RadioGroup radioGroup;
    RadioButton bgR, txtR;
    int red, green, blue, bgr,bgg,bgb,fgr,fgg,fgb;
    String bg, tc, hex= String.format ("#%02X%02X%02X", red, green, blue);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Checkboxes and Radios
        radioGroup = findViewById(R.id.rGroup);
        bgCheck = findViewById(R.id.bgCB);
        textCheck = findViewById(R.id.textCB);
        bgR = findViewById(R.id.bgRadio);
        txtR = findViewById(R.id.textRadio);
        //SeekBar stuff
        redP = findViewById(R.id.redSB);
        redT = findViewById(R.id.redTV);
        greenP = findViewById(R.id.greenSB);
        greenT = findViewById(R.id.greenTV);
        blueP = findViewById(R.id.blueSB);
        blueT = findViewById(R.id.blueTV);
        red =100;
        green = 100;
        blue = 100;
        //Color Displays
        bgT = findViewById(R.id.bgColor);
        textT = findViewById(R.id.textColor);
        display = findViewById(R.id.tv);
        //hex= String.format ("#%02X%02X%02X", red, green, blue);


        onChanges(redP);
        onChanges(greenP);
        onChanges(blueP);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.bgRadio) {
                    redP.setProgress(bgr);
                    redT.setText(String.valueOf(bgr));
                    greenP.setProgress(bgg);
                    greenT.setText(String.valueOf(bgg));
                    blueP.setProgress(bgb);
                    blueT.setText(String.valueOf(bgb));
                }
                else {
                    redP.setProgress(fgr);
                    redT.setText(String.valueOf(fgr));
                    greenP.setProgress(fgg);
                    greenT.setText(String.valueOf(fgg));
                    blueP.setProgress(fgb);
                    blueT.setText(String.valueOf(fgb));
                }
            }
        });

        bgCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    bgT.setVisibility(View.VISIBLE);
                }
                else {
                    bgT.setVisibility(View.GONE);
                }
            }
        });
        textCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    textT.setVisibility(View.VISIBLE);
                }
                else {
                    textT.setVisibility(View.GONE);
                }
            }
        });
    }
    public void setbgColors() {
        bgr = redP.getProgress();
        bgg = greenP.getProgress();
        bgb = blueP.getProgress();
        bg =  String.format ("#%02X%02X%02X", bgr, bgg, bgb);
        bgT.setText(bg);
        display.setBackgroundColor(Color.rgb(bgr, bgg, bgb));

    }
    public void setfgColors() {
        fgr = redP.getProgress();
        fgg = greenP.getProgress();
        fgb = blueP.getProgress();
        tc =  String.format ("#%02X%02X%02X", fgr, fgg, fgb);
        textT.setText(tc);
        display.setTextColor(Color.rgb(fgr, fgg, fgb));
    }

    public void setColor() {
        red = redP.getProgress();
        redT.setText(String.valueOf(red));
        green = greenP.getProgress();
        greenT.setText(String.valueOf(green));
        blue = blueP.getProgress();
        blueT.setText(String.valueOf(blue));
    }

    public void onChanges(SeekBar sb) {
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setColor();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                if (bgR.isChecked()) {
                    setbgColors();
                } else {
                    setfgColors();
                }
            }
        });

    }
}
