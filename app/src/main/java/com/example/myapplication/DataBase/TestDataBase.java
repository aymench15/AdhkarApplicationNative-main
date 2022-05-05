package com.example.myapplication.DataBase;

import java.util.ArrayList;

public class TestDataBase {
  private  ArrayList<String> Adhkar = new ArrayList<>();

    public TestDataBase (){
        initAdhkar();
    }

    public  ArrayList<String> getAdhkar ()
    {
        return  this.Adhkar;
    }
    public  void initAdhkar()
    {
        Adhkar.add("لا اله الا الله محمد رسول الله") ;
        Adhkar.add("سبحان الله و بحمده") ;
        Adhkar.add("سبحان الله العظيم") ;
        Adhkar.add("الله اكبر") ;
        Adhkar.add("الحمد لله") ;
        Adhkar.add("اللهم لا اله الا انت سبحانك  اني كنت من الظالمين") ;
    }
}
