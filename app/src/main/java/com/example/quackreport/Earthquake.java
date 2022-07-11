package com.example.quackreport;

public class Earthquake {
    private String magnitude;
    private String place;
    private String date;


    public Earthquake(String m,String p,String d){
        magnitude=m;
        place=p;
        date=d;

    }



    public String getMagnitude() {
        return magnitude;
    }

    public String getPlace() {
        return place;
    }

    public String getDate(){return date;}

}
