package com.example.sharedperferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    private final static String SharedPerferencesFileName="config";
    private final static String Key_UserName="UserName";
    private final static String Key_UserNumber="UserNumber";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(SharedPerferencesFileName,MODE_PRIVATE);
        editor=preferences.edit();
        Button buttonWrite = (Button)findViewById(R.id.button1);
        Button buttonRead = (Button)findViewById(R.id.button2);
        buttonWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString(Key_UserName,"XiaoZhan");
                editor.putString(Key_UserNumber,"2018011240");
                editor.apply();
            }
        });
        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringUserName = preferences.getString(Key_UserName,null);
                String stringUserNumber = preferences.getString(Key_UserNumber,null);
                if(stringUserName!=null&&stringUserNumber!=null){
                    Toast.makeText(MainActivity.this,"用户名："+stringUserName
                    +"学号："+stringUserNumber,Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(MainActivity.this,"无数据",Toast.LENGTH_LONG).show();
            }
        });
    }
}