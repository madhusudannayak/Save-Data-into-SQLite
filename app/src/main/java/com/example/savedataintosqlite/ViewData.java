package com.example.savedataintosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewData extends AppCompatActivity {
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        ListView listview =findViewById(R.id.list);
        mydb =new DatabaseHelper(this);

        ArrayList<String> list =new ArrayList<>();
        Cursor data =mydb.getListContents();

        if(data.getCount()==0){
            Toast.makeText(ViewData.this,"Empty data",Toast.LENGTH_SHORT).show();
             }else{
            while (data.moveToNext()){
                list.add(data.getString(1));
                ListAdapter listAdapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
                listview.setAdapter(listAdapter);
            }
        }

    }

}