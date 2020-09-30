package com.example.cis.class6colorlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] clrNoArr = {"#FF8A80", "#FF5252", "#FF80AB", "#FF4081", "#EA80FC",
            "#E040FB", "#B388FF", "#7C4DFF", "#8C9EFF", "#536DFE"};

    int [] clrImgArr = {
            R.drawable.clr1,
            R.drawable.clr2,
            R.drawable.clr3,
            R.drawable.clr4,
            R.drawable.clr5,
            R.drawable.clr6,
            R.drawable.clr7,
            R.drawable.clr8,
            R.drawable.clr9,
            R.drawable.clr10
    };

    ListView myLV;
    MyCustomAdapter adapter;
    Intent myIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLV=findViewById(R.id.lv);

        adapter = new MyCustomAdapter(this, clrNoArr, clrImgArr);

        myLV.setAdapter(adapter);

        myIntent = new Intent(this, DetailsActivity.class);

        myLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                myIntent.putExtra("clrNum", clrNoArr[i]);
                myIntent.putExtra("clrImg", clrImgArr[i]);
                MainActivity.this.startActivity(myIntent);
            }
        });


    }
}
