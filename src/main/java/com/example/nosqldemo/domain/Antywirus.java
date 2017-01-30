package com.example.nosqldemo.domain;

import org.bson.types.ObjectId;

import java.util.List;

/**
 * Created by Redbullek on 2017-01-28.
 */

public class Antywirus
{


    private ObjectId Id;
    private String nazwa;
    private int ocena;
    private List<Pakiet> anty;


    public ObjectId getId()
    {
        return Id;
    }

    public void setId(ObjectId antywirId)
    {
        this.Id = antywirId;
    }

    public String getNazwa()
    {
        return nazwa;
    }

    public void setnazwa(String nazwa)
    {
        this.nazwa = nazwa;
    }

    public int getOcena()
    {
        return ocena;
    }

    public void setOcena(int ocena)
    {
        this.ocena = ocena;
    }

    public List<Pakiet> getAnty() {
        return anty;
    }

    public void setAnty(List<Pakiet> anty) {
        this.anty = anty;
    }

}

