package com.example.dben0.assignmentthree;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView iv;
    TextView tv;
    CountDownTimer timer;

    int btnSelect = 1;

    int counter = 0;



    String [] priceOne = {"$14","$4","$41","$99","$1231"};
    String [] priceTwo = {"$12","$23","$45","$78","$34"};
    String [] priceThree = {"$42","$187","$11.05","$7","$110,101"};

    int [] picOne = {
            R.drawable.game1,
            R.drawable.game2,
            R.drawable.game3,
            R.drawable.game4,
            R.drawable.game5};

    int [] picTwo = {
            R.drawable.electronics1,
            R.drawable.electronics2,
            R.drawable.electronics3,
            R.drawable.electronics4,
            R.drawable.electronics5};

    int [] picThree = {
            R.drawable.movie1,
            R.drawable.movie2,
            R.drawable.movie3,
            R.drawable.movie4,
            R.drawable.movie5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        iv = findViewById(R.id.img);

        final Button btnOne = findViewById(R.id.button1);
        final Button btnTwo = findViewById(R.id.button2);
        final Button btnThree = findViewById(R.id.button3);

        tv.setText(priceOne[0]);
        iv.setImageResource(picOne[0]);
        btnOne.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark, getBaseContext().getTheme()));
        btnTwo.setBackgroundColor(getResources().getColor(android.R.color.darker_gray, getBaseContext().getTheme()));
        btnThree.setBackgroundColor(getResources().getColor(android.R.color.darker_gray, getBaseContext().getTheme()));

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSelect =1;

                btnOne.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark, getBaseContext().getTheme()));
                btnTwo.setBackgroundColor(getResources().getColor(android.R.color.darker_gray, getBaseContext().getTheme()));
                btnThree.setBackgroundColor(getResources().getColor(android.R.color.darker_gray, getBaseContext().getTheme()));
                timer = new CountDownTimer(5000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                        if (btnSelect == 1) {

                            if (counter < 4) {
                                counter++;
                                iv.setImageResource(picOne[counter]);
                                tv.setText(priceOne[counter]);
                            } else {
                                counter = 0;
                                iv.setImageResource(picOne[counter]);
                                tv.setText(priceOne[counter]);
                            }
                        }

                    }

                    @Override
                    public void onFinish() {
                        if (btnSelect == 1)
                            timer.start();

                    }
                }.start();
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSelect = 2;

                btnOne.setBackgroundColor(getResources().getColor(android.R.color.darker_gray, getBaseContext().getTheme()));
                btnTwo.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark, getBaseContext().getTheme()));
                btnThree.setBackgroundColor(getResources().getColor(android.R.color.darker_gray, getBaseContext().getTheme()));
                timer = new CountDownTimer(5000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                        if (btnSelect == 2) {

                            if (counter < 4) {
                                counter++;
                                iv.setImageResource(picTwo[counter]);
                                tv.setText(priceTwo[counter]);
                            } else {
                                counter = 0;
                                iv.setImageResource(picTwo[counter]);
                                tv.setText(priceTwo[counter]);
                            }
                        }
                    }

                    @Override
                    public void onFinish() {
                        if (btnSelect == 2)
                            timer.start();
                    }
                }.start();
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnSelect = 3;

                btnOne.setBackgroundColor(getResources().getColor(android.R.color.darker_gray, getBaseContext().getTheme()));
                btnTwo.setBackgroundColor(getResources().getColor(android.R.color.darker_gray, getBaseContext().getTheme()));
                btnThree.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark, getBaseContext().getTheme()));
                timer = new CountDownTimer(5000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        if (btnSelect == 3) {

                            if (counter < 4) {
                                counter++;
                                iv.setImageResource(picThree[counter]);
                                tv.setText(priceThree[counter]);

                            } else {
                                counter = 0;
                                iv.setImageResource(picThree[counter]);
                                tv.setText(priceThree[counter]);
                            }
                        }
                    }

                    @Override
                    public void onFinish() {
                        if (btnSelect == 3)
                            timer.start();
                    }
                }.start();
            }
        });
    }
}
