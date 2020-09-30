package com.example.dben0.assignmenttwo;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button upButton, downButton, leftButton, rightButton;
    ImageView image;
    TextView text;
    public int xPos = 6;
    public int yPos = 8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upButton = (Button) findViewById(R.id.upBtn);
        downButton = (Button) findViewById(R.id.downBtn);
        rightButton = (Button) findViewById(R.id.rightBtn);
        leftButton = (Button) findViewById(R.id.leftBtn);
        text = findViewById(R.id.textView);
        image = (ImageView) findViewById(R.id.imageView);

        downButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                image.setImageResource(R.drawable.arrowdown);
                text.setText("DOWN");
                downButton.getBackground().setColorFilter(downButton.getContext().getResources().getColor(R.color.green), PorterDuff.Mode.MULTIPLY);
                leftButton.getBackground().setColorFilter(leftButton.getContext().getResources().getColor(R.color.lt_gray), PorterDuff.Mode.MULTIPLY);
                rightButton.getBackground().setColorFilter(rightButton.getContext().getResources().getColor(R.color.lt_gray), PorterDuff.Mode.MULTIPLY);
                upButton.getBackground().setColorFilter(upButton.getContext().getResources().getColor(R.color.lt_gray), PorterDuff.Mode.MULTIPLY);
                if (yPos < 13)
                    yPos=yPos+1;
                image.setY(yPos * 100);
            }
        });

        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageResource(R.drawable.arrowup);
                text.setText("UP");
                upButton.getBackground().setColorFilter(upButton.getContext().getResources().getColor(R.color.green), PorterDuff.Mode.MULTIPLY);
                leftButton.getBackground().setColorFilter(leftButton.getContext().getResources().getColor(R.color.lt_gray), PorterDuff.Mode.MULTIPLY);
                rightButton.getBackground().setColorFilter(rightButton.getContext().getResources().getColor(R.color.lt_gray), PorterDuff.Mode.MULTIPLY);
                downButton.getBackground().setColorFilter(downButton.getContext().getResources().getColor(R.color.lt_gray), PorterDuff.Mode.MULTIPLY);
                if (yPos > -1)
                    yPos=yPos-1;
                image.setY(yPos * 100);
            }
        });

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageResource(R.drawable.arrowleft);
                text.setText("LEFT");
                leftButton.getBackground().setColorFilter(leftButton.getContext().getResources().getColor(R.color.green), PorterDuff.Mode.MULTIPLY);
                upButton.getBackground().setColorFilter(upButton.getContext().getResources().getColor(R.color.lt_gray), PorterDuff.Mode.MULTIPLY);
                rightButton.getBackground().setColorFilter(rightButton.getContext().getResources().getColor(R.color.lt_gray), PorterDuff.Mode.MULTIPLY);
                downButton.getBackground().setColorFilter(downButton.getContext().getResources().getColor(R.color.lt_gray), PorterDuff.Mode.MULTIPLY);
                if (xPos > -1)
                    xPos=xPos-1;
                image.setX(xPos * 100);
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageResource(R.drawable.arrowright);
                text.setText("RIGHT");
                rightButton.getBackground().setColorFilter(rightButton.getContext().getResources().getColor(R.color.green), PorterDuff.Mode.MULTIPLY);
                leftButton.getBackground().setColorFilter(leftButton.getContext().getResources().getColor(R.color.lt_gray), PorterDuff.Mode.MULTIPLY);
                upButton.getBackground().setColorFilter(upButton.getContext().getResources().getColor(R.color.lt_gray), PorterDuff.Mode.MULTIPLY);
                downButton.getBackground().setColorFilter(downButton.getContext().getResources().getColor(R.color.lt_gray), PorterDuff.Mode.MULTIPLY);
                if (xPos < 13)
                    xPos=xPos+1;
                image.setX(xPos * 100);
            }
        });
    }
}
