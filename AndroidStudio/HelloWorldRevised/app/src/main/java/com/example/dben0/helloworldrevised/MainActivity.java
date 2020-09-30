package com.example.dben0.helloworldrevised;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String [] choiceLang;
    String [] selection_lang;
    int [] flag_select;
    TextView myText;
    Button langSelect;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myText = findViewById(R.id.helloAndroid);
        langSelect = findViewById(R.id.button);
        image = findViewById(R.id.imageFlag);


        langSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                choiceLang = new String[]{"English", "French", "Spanish"};
                selection_lang = new String[] {"Hello Android","Bonjour Android","Hola Android"};
                flag_select = new int[] {R.drawable.flag_us, R.drawable.flag_france, R.drawable.flag_spain};
                AlertDialog.Builder lBuilder = new AlertDialog.Builder(MainActivity.this);
                lBuilder.setSingleChoiceItems(choiceLang, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        myText.setText(selection_lang[which]);

                        image.setImageResource(flag_select[which]);
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog lDialog = lBuilder.create();
                lDialog.show();
            }});
    }
}
