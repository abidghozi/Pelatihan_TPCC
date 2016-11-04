package com.example.gigabyte.mainproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainApp extends AppCompatActivity {

    //Variable Declaration
    private Button button_app4;
    private Button button_app2;
    private Button button_app1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);

        //Assigment Variable
        button_app4 = (Button) findViewById(R.id.bApp4);
        button_app2 = (Button) findViewById(R.id.bApp2);
        button_app1 = (Button) findViewById(R.id.bApp1);

        //Intent Function
        button_app4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent app4 = new Intent(MainApp.this, IntentApp_pg1.class);
                startActivity(app4);
            }
        });

        button_app2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent app2 = new Intent(MainApp.this, Quiz.class);
                startActivity(app2);
            }
        });
    }
}
