package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView tv4 = (TextView) findViewById(R.id.textView4);
        tv4.setText("here is kibla");
        BottomNavigationView btmNav = findViewById(R.id.btmNav);
        btmNav.setSelectedItemId(R.id.kibla);
        btmNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        return true;
                    case R.id.CD:
                        Intent intt = new Intent(getApplicationContext(), MainActivity2.class);
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

    }


}