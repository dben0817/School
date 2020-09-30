package com.example.dben0.class8recipedb;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DBHelper myDBHelper;
    SQLiteDatabase db;
    ListView myList;
    Spinner mySpinner;
    Button searchBtn;
    EditText searchTxt;
    String txt ="";
    TextView noResults;
    ArrayAdapter<String> mySpinnerAdapter, myListAdapter;

    String [] categoryArr = {"All", "Main Dish", "Side Dish", "Salad", "Soup", "Dessert", "None"};

    ArrayList<String> RNameList, RIngredientList, RPreparationList, RCategoryList, RImageList;

    String allQuery = "select * from recipe";

    boolean first = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myList = findViewById(R.id.lv);
        mySpinner = findViewById(R.id.spin);
        searchBtn = findViewById(R.id.searchBtn);
        searchTxt = findViewById(R.id.search);
        noResults = findViewById(R.id.noResults);



        //Spinner Adapter
        mySpinnerAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, categoryArr);
        mySpinner.setAdapter(mySpinnerAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String cat = categoryArr[pos];
                String catQuery="";
                if (pos!=0 && pos !=6)
                    catQuery = "select * from recipe where category =\"" + cat +"\"";

                if (first) first =false;
                if (!first && pos!=6)
                    getResults(catQuery);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //List Adapter
        myListAdapter = new ArrayAdapter<String>(this, R.layout.list_item, RNameList);
        //Setting List Adapter
        myList.setAdapter(myListAdapter);

        myDBHelper = new DBHelper(this);
        try {
            myDBHelper.createDataBase();
        } catch (IOException e){
            throw new Error("Unable to create database");

        }
        try {
            myDBHelper.openDataBase();

        } catch (SQLException sql) {

        }

        db = myDBHelper.getReadableDatabase();

        getResults(allQuery);



    }

    public void getResults(String q) {
        Cursor result = db.rawQuery(q,null);
        result.moveToFirst();
        int count = result.getCount();

        Log.i("count=", String.valueOf(count));

        int foodNumber = 1;
        if (count >=1) {
            noResults.setVisibility(View.GONE);
            myList.setVisibility(View.VISIBLE);

            do {
                RNameList.add(foodNumber + ". "+ result.getString(1));
                RIngredientList.add(result.getString(2));
                RPreparationList.add(result.getString(3));
                RImageList.add(result.getString(5));
                foodNumber++;
            } while (result.moveToNext());
        }
        else
        {
            myList.setVisibility(View.GONE);
            noResults.setVisibility(View.VISIBLE);
        }

    }
}
