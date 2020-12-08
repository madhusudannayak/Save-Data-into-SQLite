package com.example.savedataintosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mydb;
    Button view,add;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
        view=findViewById(R.id.buttonview);
        add=findViewById(R.id.buttonadd);
        mydb = new DatabaseHelper(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,ViewData.class);
                startActivity(intent);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if(editText.length()!= 0){
                    AddData(newEntry);
                    editText.setText("");
                }else{
                    toast("You mest put something in the text field");
                }
            }
        });
    }
    public void AddData(String newEntry) {

        boolean insertData = mydb.addData(newEntry);

        if(insertData==true){
            toast("Data Successfully Inserted");
        }else{
            toast("Something went wrong");
        }
    }
    public void  toast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}

