package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.myapplication.Adapter.AdhkarListAdapter;
import com.example.myapplication.DataBase.TestDataBase;
import com.example.myapplication.ui.AdhkarSabahActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
private Button adhkarSabah;
private Button adhkarMasaa;
private Button  adhkarNawm;
private Button adhkarSalat;
public String ref="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView btmNav = findViewById(R.id.btmNav);
        btmNav.setSelectedItemId(R.id.home);
        btmNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.home:
                           startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            return true;
                        case R.id.CD:
                            Intent intt = new Intent(MainActivity.this.getApplicationContext(), MainActivity2.class);
                            Bundle msg = new Bundle();
                            msg.putString("vide", "vide");
                            intt.putExtras(msg);
                            startActivity(intt);
                            return true;
                        case R.id.kibla:
                            startActivity(new Intent(getApplicationContext(),MainActivity3.class));
                            return true;
                        default:

                    }
                    return false;

            }
        });

        adhkarSabah = findViewById(R.id.sabah_adhkar);
        adhkarSabah.setOnClickListener(view-> {
            Intent intent = new Intent(this, AdhkarSabahActivity.class);
            intent.putExtra("filename","sabah.txt");
            startActivity(intent);
        });
        adhkarNawm = findViewById(R.id.adhkarnawm);
        adhkarNawm.setOnClickListener(view-> {
            Intent intent = new Intent(this, AdhkarSabahActivity.class);
            intent.putExtra("filename","nawm.txt");
            startActivity(intent);
        });

        adhkarSalat = findViewById(R.id.adhkarSalat);
        adhkarSalat.setOnClickListener(view-> {
            Intent intent = new Intent(this, AdhkarSabahActivity.class);
            intent.putExtra("filename","salat.txt");
            startActivity(intent);
        });

        adhkarMasaa = findViewById(R.id.masaa_adhkar);
        adhkarMasaa.setOnClickListener(view-> {
            Intent intent = new Intent(this, AdhkarSabahActivity.class);
            intent.putExtra("filename","masaa.txt");
            startActivity(intent);
        });

            Bundle b = new Bundle();
            ref =b.getString("reflex");

            if(ref!=null){

                if(ref.equals("الغاء اظهار الاشعارات")){

                    Switch sw=(Switch)findViewById(R.id.switch3);
                    sw.setText("الغاء اظهار الاشعارات");
                }
            }


    }
    public void activer(View v) {
        Switch sw=(Switch)findViewById(R.id.switch3);

        Toast.makeText(this,sw.getText().toString(),Toast.LENGTH_LONG).show();
        Intent pass = new Intent(this.getApplicationContext(), MainActivity2.class);
        Bundle disactive = new Bundle();
        disactive.putString("case",sw.getText().toString());
        pass.putExtras(disactive);
        sw.setText("إلغاء ظهور الاشعارات");
        startActivity(pass);
    }
    public void gone(View view){
        FrameLayout fl =(FrameLayout) findViewById(R.id.frameLayout3);
        fl.setVisibility(view.VISIBLE);
    }
    public void back(View view){
        FrameLayout fl =(FrameLayout) findViewById(R.id.frameLayout3);
        fl.setVisibility(view.INVISIBLE);
    }



    }