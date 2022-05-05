package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.myapplication.ui.Database;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity2 extends AppCompatActivity {


    private boolean index=false;
    public String active = "";
    public boolean bool=true;
    LinearLayout mylayout;
    FloatingActionButton btn;
    ArrayList<String> adhkarDB;
    public Cursor cr;
    public int index2=0;
    ArrayList<String> arr;
    private int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        arr=new ArrayList<String>();
        BottomNavigationView btmNav = findViewById(R.id.btmNav);
        FrameLayout fr=findViewById(R.id.FL);
        fr.setVisibility(View.INVISIBLE);
        btmNav.setSelectedItemId(R.id.CD);
        btmNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        Intent intt = new Intent(getApplicationContext(), MainActivity.class);
                        Bundle msg = new Bundle();
                        msg.putString("reflex", "الغاء اظهار الاشعارات");
                        intt.putExtras(msg);

                        startActivity(intt);
                        return true;
                    case R.id.CD:
                        startActivity(new Intent(getApplicationContext(),MainActivity2.class));
                        return true;
                    case R.id.kibla:
                        startActivity(new Intent(getApplicationContext(),MainActivity3.class));
                        return true;
                    default:

                }
                return false;

            }
        });
                mylayout=(LinearLayout)findViewById(R.id.addlay1);
                btn=(FloatingActionButton)findViewById(R.id.btn3);
adhkarDB=new ArrayList<String>();

displaydata();

        Bundle b = this.getIntent().getExtras();
        active = b.getString("case");
        if(active !=null) {
            if (active.equals("ظهور الاشعارات")) {

                notifyy();
            }

        }
        else
            bool=false;
    }

    public void notifyy() {
        final NotificationManager notificationManager = (NotificationManager)this.getSystemService(this.NOTIFICATION_SERVICE);
        (
                new Thread(
                        new Runnable() {
           // int indice = 0;

            public void run() {
                while(bool) {
                    for(String s:adhkarDB) {
                       // String s = (String)var1.next();
                        NotificationCompat.Builder builder = null;
                        builder = new NotificationCompat.Builder(MainActivity2.this.getApplicationContext(), "channel1");
                        builder = builder.setSmallIcon(android.R.drawable.ic_popup_reminder)
                                .setContentTitle("اذكاري")
                                .setContentText("{ " + s + " }")
                                .setDefaults(-1).setAutoCancel(true).setColor(Color.YELLOW);
                        notificationManager.notify(1, builder.build());

                        try {
                            Thread.sleep(20000);
                        } catch (InterruptedException var5) {
                            var5.printStackTrace();
                        }
                    }
                }
            }
        })).start();
    }


    public void displaydata(){
        Database db=new Database(this);
        cr= db.getdata();
        if(cr.getCount()==0)
            Toast.makeText(this,"there is no data ! ",Toast.LENGTH_LONG).show();
        else{
        while(cr.moveToNext()){
            adhkarDB.add(cr.getString(0));
        }}
        for (String s:adhkarDB){
            View view = getLayoutInflater().inflate(R.layout.addlayout, null, false);
            TextView txt = (TextView) view.findViewById(R.id.txt);
    txt.setText(s);
            ImageButton btn1 = (ImageButton) view.findViewById(R.id.btn1);
            //  ImageButton btn2=(ImageButton)view.findViewById(R.id.btn2);
            mylayout.addView(view, index2);
        }

    }

    public void onClick(View view){
        EditText etxt=(EditText)findViewById(R.id.etxt);
        if(!etxt.getText().toString().isEmpty()) {
        addView();
        addString(); }

        else
            Toast.makeText(this,"write your dhikr please ! ",Toast.LENGTH_LONG).show();
    }
    public void afficherF(View view){
        EditText etxt=(EditText)findViewById(R.id.etxt);
        etxt.setText("");
        FrameLayout fr=findViewById(R.id.FL);
        fr.setVisibility(View.VISIBLE);
    }
    public void addView(){

        if(!index){

                index = true;
                View view = getLayoutInflater().inflate(R.layout.addlayout, null, false);
                TextView txt = (TextView) view.findViewById(R.id.txt);

                ImageButton btn1 = (ImageButton) view.findViewById(R.id.btn1);
                //  ImageButton btn2=(ImageButton)view.findViewById(R.id.btn2);
                mylayout.addView(view, index2);

                index2++;


            }
        else
            Toast.makeText(this,"You already opening a view ",Toast.LENGTH_LONG).show();

    }
    public void addString(){
        EditText etxt=(EditText)findViewById(R.id.etxt);
            FrameLayout fr=findViewById(R.id.FL);
            fr.setVisibility(View.INVISIBLE);

            index=false;
            mylayout.setVisibility(View.VISIBLE);
            TextView txt=mylayout.getChildAt(i).findViewById(R.id.txt);
            arr.add(txt.getText().toString());
            System.out.println(txt.getText().toString());
        Database db=new Database(this);
        db.adddhikr(etxt.getText().toString());
            txt.setText(etxt.getText().toString());
            i++;


       // ImageButton btn2=mylayout.getChildAt(i).findViewById(R.id.btn2);
      //  ImageButton btn1=(ImageButton)view.findViewById(R.id.btn1);
       // btn2.setVisibility(View.INVISIBLE);
      //  btn1.setVisibility(View.INVISIBLE);


        //Toast.makeText(this,arr.get(i),Toast.LENGTH_LONG).show();
       // String.valueOf(i)

        //view.setVisibility(View.INVISIBLE);
    }


}