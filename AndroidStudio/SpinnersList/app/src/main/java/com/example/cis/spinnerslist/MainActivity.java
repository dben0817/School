package com.example.cis.spinnerslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    ListView myList;
    ArrayAdapter<String> myAdapterSide;
    ArrayAdapter<String> myAdapterMain;
    ArrayAdapter<String> myAdapterSalad;
    ArrayAdapter<String> myAdapterDessert;

    Spinner mySpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myList = findViewById();
        mySpinner = findViewById();
        myAdapterSide = ;
        myAdapterMain = ;
        myAdapterSalad = ;
        myAdapterDessert = ;

        myList.setAdapter(myAdapterSide);
    }

    public void setFood(int cat, int pos) {
        int i = pos;

        switch(cat) {
            case 0:
                myList.setAdapter(myAdapterSide);
                break;
            case 1:
                myList.setAdapter(myAdapterMain);
                break;
            case 2:
                myList.setAdapter(myAdapterSalad);
                break;
            case 3:
                myList.setAdapter(myAdapterDessert);
                break;
        }

    }
}
