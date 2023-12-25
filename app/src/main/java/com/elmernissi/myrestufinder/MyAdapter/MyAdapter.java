package com.elmernissi.myrestufinder.MyAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elmernissi.myrestufinder.R;
import com.elmernissi.myrestufinder.model.Magasin;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myholder> {
    private List<Magasin> magasinList;

    public MyAdapter(List<Magasin> magasinList) {
        this.magasinList = magasinList;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_magasin_item,parent,false);
        return new Myholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
      Magasin magasin = magasinList.get(position);
      holder.Afichage.setText(magasin.getNom()+"\n"+magasin.getAddress()+"\n"+magasin.getTel());

    }

    @Override
    public int getItemCount() {
        return magasinList.size();
    }
    public static class Myholder extends RecyclerView.ViewHolder{
        TextView Afichage;
        public Myholder(@NonNull View itemView) {
            super(itemView);
            Afichage = itemView.findViewById(R.id.nomTextView);
        }
    }
}
