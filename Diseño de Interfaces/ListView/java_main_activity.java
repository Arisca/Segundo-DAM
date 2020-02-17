package com.example.playjuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class About extends AppCompatActivity
{
    ListView listausuarios;
    VersionsAdapter adapter;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ListView listaUsers = findViewById(R.id.Listview);
        View cabecera = getLayoutInflater().inflate(R.layout.header_list, null);
        listaUsers.addHeaderView(cabecera);

        final ArrayList<AndroidVersion> versions = new ArrayList<>();
        versions.add(new AndroidVersion("Maria Mata",       "2014",        R.mipmap.maria     ));
        versions.add(new AndroidVersion("Antonio Sanz",     "1890",        R.mipmap.antonio   ));
        versions.add(new AndroidVersion("Carlos",           "967",         R.mipmap.carlos    ));
        versions.add(new AndroidVersion("Berta",            "945",         R.mipmap.berta     ));
        versions.add(new AndroidVersion("Héctor Campos",    "879",         R.mipmap.hector    ));
        versions.add(new AndroidVersion("Ismael",           "678",         R.mipmap.ismael    ));
        versions.add(new AndroidVersion("Iván García",      "567",         R.mipmap.ivan      ));
        versions.add(new AndroidVersion("Erika García",     "2019",        R.mipmap.erika     ));


        listausuarios = findViewById(R.id.Listview);
        adapter = new VersionsAdapter(About.this, versions);

        listausuarios.setAdapter(adapter);

        listausuarios.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(About.this, versions.get(position-1).getNombre(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
