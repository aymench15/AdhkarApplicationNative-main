package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ActivityNavigatorDestinationBuilderKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Adapter.AdhkarListAdapter;
import com.example.myapplication.DataBase.TestDataBase;
import com.example.myapplication.MainActivity;
import com.example.myapplication.Model.Deker;
import com.example.myapplication.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AdhkarSabahActivity extends AppCompatActivity {
    private TestDataBase db = new TestDataBase();
    private AdhkarListAdapter adapter = new AdhkarListAdapter() ;
    private ArrayList<Deker> adhkar = null;
    private  RecyclerView recyclerView ;
    private  TextView title ;
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adhkar_sabah);
          
        String filename = getIntent().getStringExtra("filename");
    title = findViewById(R.id.page_title);
    if (filename.contains("masaa"))
        title.setText("أذكار المساء");
    else if(filename.contains("sabah"))
        title.setText("أذكار الصباح");
    else if(filename.contains("nawm"))
        title.setText("أذكار النوم");
    else if(filename.contains("salat"))
        title.setText("أذكار الصلاه");

        adhkar = readFromFile(filename.toString().trim());

        setRecycler();

    }

    private void setRecycler (){
        adapter.setAdhkarList(adhkar);
        recyclerView = findViewById(R.id.adhkar_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new AdhkarListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick (int position){
                if( (adhkar.get(position).getRepetition()-1) == 0 )
                        removeItem(position);
                else{
                adhkar.get(position).setRepetition(adhkar.get(position).getRepetition()-1);
                adapter.setAdhkarList(adhkar);
                }
            }
        });

    }
    public void removeItem(int position) {
        adhkar.remove(position);
        adapter.notifyItemRemoved(position);
    }

    private ArrayList<Deker> readFromFile(String filename) {
        ArrayList<Deker> adkhar = new ArrayList<>();
        BufferedReader reader;
        int repetition;
        try{
            final InputStream file = getAssets().open(filename);
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();
            while(line != null){

                StringTokenizer st = new StringTokenizer(line,".");
                String deker = st.nextToken();
                String count = st.nextToken();
                repetition = Integer.parseInt(count);
                adkhar.add(new Deker(deker,repetition));
                line = reader.readLine();
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return  adkhar;
    }
    public void backhome(View v){
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }

}