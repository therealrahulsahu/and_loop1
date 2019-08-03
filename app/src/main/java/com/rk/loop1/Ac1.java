package com.rk.loop1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ac1 extends AppCompatActivity {
    Button bt1,bt2,bt3;
    EditText et1;
    TextView tv1;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac1);
        et1 = findViewById(R.id.et1_id);
        tv1 = findViewById(R.id.tv1_id);
        bt1 = findViewById(R.id.bt1_id);
        bt2 = findViewById(R.id.bt2_id);
        bt3 = findViewById(R.id.bt3_id);
        sp = getSharedPreferences("dataFile", Context.MODE_PRIVATE);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrive();
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });

    }
    private void delete()
    {
        SharedPreferences.Editor editor;
        editor=sp.edit();
        editor.clear();
        editor.apply();
        Toast.makeText(this,"Data Cleared",Toast.LENGTH_SHORT).show();
    }
    private void retrive()
    {
        String data=sp.getString("name","");
        tv1.setText(data);

    }
    private void saveData()
    {
        SharedPreferences.Editor editor;
        String data=et1.getText().toString();
        editor=sp.edit();
        editor.putString("name",data);
        editor.putString("roll","1234");
        editor.apply();
        et1.setText("");
        Toast.makeText(this,":Data inserted Successful",Toast.LENGTH_SHORT).show();
    }
}
