package com.example.sqliteapp02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.sqliteapp02.model.MyDb;
import com.example.sqliteapp02.model.Produit;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    Button btn;

    MyDb myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       lv = findViewById(R.id.listV);
       btn = findViewById(R.id.ajouteBtn);
      myDb = new MyDb(this);

       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent in = new Intent(MainActivity.this, MainActivity2.class);
               startActivity(in);

           }
       });
        List<Produit> produitList = myDb.getData();
        ProduitAdapter produitAdapter = new ProduitAdapter(produitList,this);
        lv.setAdapter(produitAdapter);

    }
}