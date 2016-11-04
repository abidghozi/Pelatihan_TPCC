package com.example.gigabyte.mainproject;

/**
 * Created by GIGABYTE on 04/11/2016.
 */

public class AndroData {
    private int img;
    private String desc;
    private int backg;

    public AndroData(int y, String x, int z){
        this.desc = x;
        this.img = y;
        this.backg = z;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getBackg() {
        return backg;
    }

    public void setBackg(int backg) {
        this.backg = backg;
    }
}
