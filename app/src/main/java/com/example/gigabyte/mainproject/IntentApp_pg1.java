package com.example.gigabyte.mainproject;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.DatePicker;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class IntentApp_pg1 extends AppCompatActivity {

    private Button back, next;
    private EditText send,tgl;
    private ImageView prof;
    private final int SELECT_PHOTO = 1;
    private int width, height;
    byte[] byteArray;
    private Bitmap selectedImage;
    private Spinner pilihan_jk;
    private String jk_terpilih;

    public static Activity fa;

    private Calendar cal;
    private int day;
    private int month;
    private int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_app_pg1);

        jk_terpilih = "Laki-laki";
        fa = this;

        back = (Button) findViewById(R.id.button);
        next = (Button) findViewById(R.id.button2);
        send = (EditText) findViewById(R.id.editText);
        prof = (ImageView) findViewById(R.id.imageView);
        pilihan_jk = (Spinner) findViewById(R.id.spinner);
        tgl = (EditText) findViewById(R.id.editText3);

        List<String> jk = new ArrayList<String>();
        jk.add("Laki-laki");
        jk.add("Perempuan");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, jk);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pilihan_jk.setAdapter(dataAdapter);

        pilihan_jk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // On selecting a spinner item
                jk_terpilih = adapterView.getItemAtPosition(i).toString();
                System.out.println(jk_terpilih);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedImage == null) {
                    Toast.makeText(IntentApp_pg1.this, "Pilih Gambar Dahulu!!!", Toast.LENGTH_LONG).show();
                } else {
                    Intent nex = new Intent(IntentApp_pg1.this, IntentApp_pg2.class);

                    String message = send.getText().toString();
                    nex.putExtra("nama", message);
                    nex.putExtra("jk",jk_terpilih);

                    ByteArrayOutputStream bs = new ByteArrayOutputStream();
                    selectedImage.compress(Bitmap.CompressFormat.PNG, 90, bs);
                    nex.putExtra("byteArray", bs.toByteArray());

                    //startActivity(nex);
                }
            }
        });

        send.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                send.setText("");
            }
        });


        prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, SELECT_PHOTO);
            }
        });

        cal = Calendar.getInstance();
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);

        tgl.setText("dd/mm/yyyy");

        tgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener a = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int y, int m, int d) {
                        tgl.setText(d+"/"+m+"/"+y);
                    }
                };
                DatePickerDialog dpDialog=new DatePickerDialog(IntentApp_pg1.this, a, year, month, day);
                dpDialog.show();
            }
        });
    }

    public void DateDialog(){



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch (requestCode) {
            case SELECT_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        selectedImage = BitmapFactory.decodeStream(imageStream);
                        prof.setImageBitmap(selectedImage);

                        width = selectedImage.getWidth();
                        height = selectedImage.getHeight();

                        int size = selectedImage.getRowBytes() * selectedImage.getHeight();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(size);
                        selectedImage.copyPixelsToBuffer(byteBuffer);
                        byteArray = byteBuffer.array();


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                }
        }
    }



}
