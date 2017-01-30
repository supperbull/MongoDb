package com.example.nosqldemo.domain;

import org.bson.types.ObjectId;

/**
 * Created by Redbullek on 2017-01-28.
 */

public class Pakiet
{


    private ObjectId Id;

    private String nazwapakiet;

    private String opis;

    private double cena;



    public ObjectId getId() {
        return Id;
    }

    public void setId(ObjectId pakietId) {
        this.Id = pakietId;
    }
    public String getNazwapakiet()
    {
        return nazwapakiet;
    }
    public void setNazwapakiet(String nazwapakiet){
        this.nazwapakiet = nazwapakiet;
    }
    public String getOpis(){
        return opis;
    }
    public void setOpis(String opis){
        this.opis = opis;
    }
    public Double getCena(){
        return cena;
    }
    public void setCena(Double cena){
        this.cena = cena;
    }

}

