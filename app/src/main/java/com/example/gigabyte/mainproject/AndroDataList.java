package com.example.gigabyte.mainproject;

import android.graphics.Color;

import java.util.ArrayList;

/**
 * Created by GIGABYTE on 04/11/2016.
 */

public class AndroDataList {

    ArrayList<AndroData> isi;

    public ArrayList<AndroData> getDataAndro() {
        isi = new ArrayList<AndroData>();
        isi.add(new AndroData(R.drawable.andro_cupcake,"Cupcake", Color.argb(100, 175, 251, 51)));
        isi.add(new AndroData(R.drawable.andro_donut,"Donut",Color.argb(100, 255, 202, 51)));
        isi.add(new AndroData(R.drawable.andro_eclair,"Eclair",Color.argb(100, 255, 178, 51)));
        isi.add(new AndroData(R.drawable.andro_froyo,"Froyo",Color.argb(100, 51, 255, 85)));
        isi.add(new AndroData(R.drawable.andro_ginger,"Gingerbread",Color.argb(100, 255, 138, 51)));
        isi.add(new AndroData(R.drawable.andro_honey,"Honey",Color.argb(100, 51, 116, 255)));
        isi.add(new AndroData(R.drawable.andro_ics,"ICS",Color.argb(100, 222, 54, 0)));
        isi.add(new AndroData(R.drawable.andro_jelly,"Jellybean",Color.argb(100, 255, 37, 37)));
        isi.add(new AndroData(R.drawable.andro_kitkat,"Kitkat",Color.argb(100, 135, 45, 0)));
        isi.add(new AndroData(R.drawable.andro_lol,"Lollipop",Color.argb(100, 255, 98, 98)));
        isi.add(new AndroData(R.drawable.andro_marsh,"Marshmallow",Color.argb(100, 224, 224, 224)));
        isi.add(new AndroData(R.drawable.andro_nougat,"Nougat",Color.argb(100, 189, 96, 74)));
        return isi;
    }
    public AndroDataList(){
        AndroDataList.this.getDataAndro();
    }

    public int getSize(){
        return isi.size();
    }

    public int getDataImg(int a){
        return(isi.get(a).getImg());
    }

    public String getDataDesc(int a){
        return(isi.get(a).getDesc());
    }

    public int getDataBackg(int a){
        return(isi.get(a).getBackg());
    }

}
