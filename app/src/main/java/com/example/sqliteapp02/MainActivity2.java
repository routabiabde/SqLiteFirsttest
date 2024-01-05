package com.example.sqliteapp02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sqliteapp02.model.MyDb;
import com.example.sqliteapp02.model.Produit;
import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity2 extends AppCompatActivity {
    MaterialToolbar toolbar;

    EditText nameEditText,prixEditText;
    TextView tx ;

    MyDb myDb ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toolbar = findViewById(R.id.appBar);
        nameEditText = findViewById(R.id.name);
        prixEditText = findViewById(R.id.prix);
        tx = findViewById(R.id.test);
        myDb = new MyDb(this);

        toolbar.setNavigationOnClickListener(v -> {
            Intent in = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(in);
        });


        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id =   item.getItemId();
                if (id == R.id.save){
                    String nameProd = nameEditText.getText().toString();
                    String prixProd = prixEditText.getText().toString();
                    tx.setText(myDb.add(new Produit(nameProd,prixProd,null))+" ");
                }
                else {
                    nameEditText.setText("Delete");
                }
                return true;
            }
        });
    }
}