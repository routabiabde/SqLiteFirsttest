package com.example.sqliteapp02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sqliteapp02.model.MyDb;
import com.example.sqliteapp02.model.Produit;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MaterialToolbar toolbar;
    ListView lv;
    ProduitAdapter produitAdapter;

    TextView searchText;

    ImageButton searchBtn;

    LinearLayout ln;

    Button btn;

    MyDb myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       lv = findViewById(R.id.listV);
       btn = findViewById(R.id.ajouteBtn);
       myDb = new MyDb(this);
       toolbar = findViewById(R.id.mainAppBar);
       searchBtn = findViewById(R.id.searchBtn);
       ln = findViewById(R.id.searchLayout);
       searchText = findViewById(R.id.SearchEditeText);


       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent in = new Intent(MainActivity.this, MainActivity2.class);
               startActivity(in);

           }
       });
        List<Produit> produitList = myDb.getData();
        produitAdapter = new ProduitAdapter(produitList,this);


        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchTxt = searchText.getText().toString();
                List<Produit> prod01 = myDb.Search(searchTxt);
                produitAdapter.setProduitList(prod01);
//                produitAdapter.notifyDataSetChanged();
                lv.setAdapter(produitAdapter);
            }
        });


        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id =   item.getItemId();
                if (id == R.id.searchBar){
                    if (ln.getVisibility() == View.VISIBLE){
                        ln.setVisibility(View.GONE);
                    }else {
                        ln.setVisibility(View.VISIBLE);
                    }
                }
                return true;
            }
        });
    }

    @Override
    protected void onStart() {
        List<Produit> produitList = myDb.getData();
        ProduitAdapter produitAdapter = new ProduitAdapter(produitList,this);
        lv.setAdapter(produitAdapter);
        super.onStart();
    }

    public  void  OnSearch(String name){
        produitAdapter.setProduitList(myDb.Search(name));

    }
}