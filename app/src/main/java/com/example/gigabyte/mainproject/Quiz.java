package com.example.gigabyte.mainproject;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Quiz extends AppCompatActivity {

    private LinearLayout warna_backg;
    private ImageView gambar_andro;
    private TextView text_andro;
    private Button ganti_gambar;
    private Button test;
    private EditText tebak;

    private int ranAndro;
    private Random ranGenAndro;
    private int x;
    private int score;
    private TextView scrText,tmrText;

    private AndroDataList a = new AndroDataList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        warna_backg = (LinearLayout) findViewById(R.id.activity_main);
        gambar_andro = (ImageView) findViewById(R.id.image_quiz);
        text_andro = (TextView) findViewById(R.id.text_quiz);
        ganti_gambar = (Button) findViewById(R.id.change_button);
        tebak = (EditText) findViewById(R.id.answer_quiz);
        scrText = (TextView) findViewById(R.id.score_count);
        tmrText = (TextView) findViewById(R.id.timer_count);


        ranGenAndro = new Random();
        x = 0;
        score = 0;

        ranAndro = (ranGenAndro.nextInt(a.getSize()));
        warna_backg.setBackgroundColor(a.getDataBackg(ranAndro));
        gambar_andro.setImageResource(a.getDataImg(ranAndro));
        text_andro.setText(a.getDataDesc(ranAndro));

        ganti_gambar.setText("Start");
        text_andro.setText("I'm ");

        tebak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tebak.setText("");
            }
        });

        ganti_gambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(x==0){
                    x++;
                    new CountDownTimer(60000, 1000) {

                        public void onTick(long cd) {
                            tmrText.setText("" + cd / 1000);
                            ganti_gambar.setText("Check");
                        }

                        public void onFinish() {
                            tmrText.setText("0");
                            Toast.makeText(Quiz.this, "Waktu Habis!", Toast.LENGTH_LONG).show();
                            x=10;
                        }

                    }.start();
                }else if(x==10) {
                    ganti_gambar.setText("Finish");
                }else{
                    String x = tebak.getText().toString();
                    if (x.equalsIgnoreCase(a.getDataDesc(ranAndro))) {

                        ranAndro = (ranGenAndro.nextInt(a.getSize()));
                        warna_backg.setBackgroundColor(a.getDataBackg(ranAndro));
                        gambar_andro.setImageResource(a.getDataImg(ranAndro));
                        text_andro.setText("I'm ");
                        Toast.makeText(Quiz.this, "Good!!!", Toast.LENGTH_SHORT).show();
                        tebak.setText("");
                        score += 10;
                        scrText.setText("" +
                                score);
                    } else {
                        Toast.makeText(Quiz.this, "Coba Lagi!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


//
    }


}
