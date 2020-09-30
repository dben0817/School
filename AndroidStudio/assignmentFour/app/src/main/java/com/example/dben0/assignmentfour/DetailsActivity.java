package com.example.dben0.assignmentfour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView rName, rDesc;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView rName = findViewById(R.id.rName);
        ImageView img = findViewById(R.id.rImg);
        TextView rDesc = findViewById(R.id.rDesc);

        Intent rIntent = getIntent();
        String str = rIntent.getStringExtra("rName");
        rName.setText(str);

        String str2 = rIntent.getStringExtra("rDesc");
        rDesc.setText(str2);

        int num = rIntent.getIntExtra("rImg", 0);
        img.setImageResource(num);
    }
}
