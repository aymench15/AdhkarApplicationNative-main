package com.example.myapplication.Model;
public class Deker {
    public Deker (String deker, int repetition){
        this.deker = deker;
        this.repetition = repetition;
    }

    private String deker;
    private int repetition;

    public String getDeker (){
        return deker;
    }

    public void setDeker (String deker){
        this.deker = deker;
    }

    public int getRepetition (){
        return repetition;
    }

    public void setRepetition (int repetition){
        this.repetition = repetition;
    }
}
