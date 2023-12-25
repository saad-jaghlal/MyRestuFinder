package com.elmernissi.myrestufinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import com.elmernissi.myrestufinder.MyAdapter.MyAdapter;
import com.elmernissi.myrestufinder.model.Magasin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<Magasin> magasins;
    private Spinner citySpinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        citySpinner =  findViewById(R.id.citySpinner);
        // Exemple de données pour le RecyclerView
        generateData();
        //Declarer le Adapter et passer les données magasins
        adapter = new MyAdapter(magasins);
//        setAdapter(adapter) a le recyclerView
        recyclerView.setAdapter(adapter);
        // Initialiser le Spinner\
        String[] cities = getResources().getStringArray(R.array.cities);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(adapter);

        // Ajouter un écouteur de sélection au Spinner
        citySpinner.setOnItemSelectedListener(this);
        //Ajouter le menu a l'application



    }
    private void generateData() {
        magasins =  new ArrayList<>();
        magasins.add(new Magasin("restu1", "Safi", "0659225"));
        magasins.add(new Magasin("restu2", "Safi", "0659225"));
        magasins.add(new Magasin("restu3", "Safi", "0659225"));
        magasins.add(new Magasin("restu1", "Rabat", "06592777"));
        magasins.add(new Magasin("restu2", "Rabat", "06592777"));
        magasins.add(new Magasin("restu1", "Fes", "06598855"));
        magasins.add(new Magasin("restu1", "Casa", "0659555525"));
        magasins.add(new Magasin("restu2", "Casa", "0659555525"));
        magasins.add(new Magasin("restu3", "Casa", "0659555525"));
    }

    public List<Magasin> getMagasins() {
        List<Magasin>   listSelected = new ArrayList<>();
        for (int i = 0; i <magasins.size() ; i++) {
            if (magasins.get(i).getAddress().equals(citySpinner.getSelectedItem().toString())){
                listSelected.add(magasins.get(i));
            }
        }
        return listSelected;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),"saad"+position , Toast.LENGTH_LONG).show();
//        List<Magasin>   listSelected = new ArrayList<>();
//        for (int i = 0; i <magasins.size() ; i++) {
//            if (magasins.get(i).getAddress().equals(citySpinner.getSelectedItem().toString())){
//                listSelected.add(magasins.get(i));
//            }
//        }
//        listSelected.add(magasins.get(position));
//        adapter = new MyAdapter(listSelected);
//        recyclerView.setAdapter(adapter);
        adapter.filterData(getMagasins());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}