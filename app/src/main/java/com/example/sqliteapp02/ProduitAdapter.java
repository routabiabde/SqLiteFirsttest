package com.example.sqliteapp02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sqliteapp02.model.MyDb;
import com.example.sqliteapp02.model.Produit;

import java.util.List;

public class ProduitAdapter extends BaseAdapter {
    List<Produit> produitList;

    Context context ;

    MyDb myDb ;



    public ProduitAdapter(List<Produit> pro,Context con) {
        produitList = pro;
        context = con;
        myDb = new MyDb(con);
    }


    @Override
    public int getCount() {
        return produitList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
//    Produit deletProd;

    @Override
    public View getView(int i, View View, ViewGroup parent) {
        Produit prod = produitList.get(i);
        if (View == null){
            View = LayoutInflater.from(context).inflate(R.layout.produit_view,null);
        }

        TextView nameText = View.findViewById(R.id.nameTexr);
        TextView prixText = View.findViewById(R.id.PrixText);
        nameText.setText(prod.getName());
        prixText.setText(prod.getId()+" Dh");

        View.setOnLongClickListener(v ->{
             produitList.remove(i);
             myDb.Delet(prod.getId());
//           nameText.setText(deletProd.getName()+"hh");
             notifyDataSetChanged();
             return  true;
        });

        return View;
    }
}
