package com.example.cis.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView myList;
    ArrayAdapter<String> myAdapter;

    String[] mNameArr={

            "1. The Nutcracker and the Four Realms (2018)",

            "2. Incredibles (2018)",

            "3. Hotel Transylvania 3: Summer Vacation (2018)",

            "4. Goosebumps 2: Haunted Halloween (2018)",

            "5. The House with a Clock in Its Walls (2018)"};

    String[] mDetailsArr={"A young girl is transported into a magical world of gingerbread soldiers and an army of mice.",

            "Bob Parr (Mr. Incredible) is left to care for the kids while Helen (Elastigirl) is out saving the world.",

            "Count Dracula and company participate in a cruise for sea-loving monsters, unaware that their boat is being commandeered by the monster-hating Van Helsing family.",

            "Halloween comes to life in a comedy adventure based on R.L. Stine's 400-million-selling series of books.",

            "A young orphan named Lewis Barnavelt aids his magical uncle in locating a clock with the power to bring about the end of the world."};

    int [] mPic={R.drawable.m1,R.drawable.m2,R.drawable.m3, R.drawable.m4, R.drawable.m5};

    int index=0;
    TextView mNameTV;
    TextView mDetailsTV;
    ImageView mImg;
//clr=#F3E5F5 clr2=#E1BEE7


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameTV = findViewById(R.id.mName);
        mDetailsTV = findViewById(R.id.desc);
        mImg = findViewById(R.id.mImg);

        myList = findViewById(R.id.lv);
        myAdapter = new ArrayAdapter<String>(this, R.layout.list_item, mNameArr);

        mNameTV.setText(mNameArr[0]);
        mDetailsTV.setText(mDetailsArr[0]);
        mImg.setBackgroundResource(mPic[0]);
        myList.setAdapter(myAdapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {

                mNameTV.setText(mNameArr[pos]);
                mDetailsTV.setText(mDetailsArr[pos]);
                mImg.setImageResource(mPic[pos]);
            }
        });
    }
}
