package com.example.gigabyte.mainproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.nio.ByteBuffer;

public class IntentApp_pg2 extends AppCompatActivity {

    private Button back, finish;
    private TextView dtpesan, dtjk;
    private Bundle bundle;
    private ImageView img_info;
    private String[] jk = {"Laki-laki","Perempuan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_app_pg2);

        back = (Button) findViewById(R.id.button3);
        finish = (Button) findViewById(R.id.button5);
        dtpesan = (TextView) findViewById(R.id.textView4);
        img_info = (ImageView) findViewById(R.id.imageView4);
        dtjk = (TextView) findViewById(R.id.textView6);

        bundle = getIntent().getExtras();
        dtpesan.setText("Nama : "+bundle.getString("nama"));
        dtjk.setText(bundle.getString("jk"));

        Bitmap b = BitmapFactory.decodeByteArray(
                getIntent().getByteArrayExtra("byteArray"),0,getIntent().getByteArrayExtra("byteArray").length);
        img_info.setImageBitmap(b);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentApp_pg1.fa.finish();
                finish();
            }
        });

    }
}
