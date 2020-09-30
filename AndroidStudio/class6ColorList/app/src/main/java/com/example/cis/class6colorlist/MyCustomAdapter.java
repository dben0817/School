package com.example.cis.class6colorlist;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyCustomAdapter extends ArrayAdapter<String>
{
    Activity context;
    String [] clrNum;
    int [] clrImg;


    public MyCustomAdapter(Activity context, String[] cNum, int[] cImg)
    {
        super(context, R.layout.list_item, cNum);

        this.context=context;
        this.clrNum = cNum;
        this.clrImg = cImg;
    }

    static class ViewHolder {

        TextView myText;
        ImageView myImg;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View rowView, @NonNull ViewGroup parent) {
        ViewHolder myVH = new ViewHolder();
        if (rowView == null){
            LayoutInflater myInflater = context.getLayoutInflater();
            rowView = myInflater.inflate(R.layout.list_item, parent, false);

            myVH.myText=rowView.findViewById(R.id.tv);
            myVH.myImg=rowView.findViewById(R.id.iv);

            rowView.setTag(myVH);
        }
        else {

            myVH= (ViewHolder) rowView.getTag();
        }

        myVH.myText.setText(clrNum[position]);
        myVH.myImg.setImageResource(clrImg[position]);

        return rowView;
    }
}
