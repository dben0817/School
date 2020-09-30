package com.example.cis.class2movingimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button upButton, downButton;
    ImageView image;
    public int pos=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upButton = (Button)findViewById(R.id.up);
        downButton = (Button)findViewById(R.id.down);
        image = (ImageView) findViewById(R.id.image);

        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if  (pos <8)
                    pos=pos+1;
                image.setY(pos * 100);
            }
        });

        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pos >-5)
                    pos = pos -1;
                image.setY(pos * 100);

            }
        });
}
}
