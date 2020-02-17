package com.example.travel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static android.R.layout.*;

public class MainActivity extends AppCompatActivity {

    private ListView listview;

    int[] imagen = new int[]{R.mipmap.arbol, R.mipmap.ballena, R.mipmap.bosque, R.mipmap.camino, R.mipmap.desierto, R.mipmap.flores, R.mipmap.tortuga, R.mipmap.tucan};

    String[] nombre = new String[]{"Card 1", "Card 2", "Card 3", "Card 4", "Card 5", "Card 6", "Card 7", "Card 8"};


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        listview = findViewById( R.id.Listview );

        MainAdapter adapater = new MainAdapter( MainActivity.this, nombre, imagen );
        listview.setAdapter( adapater );
        listview.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText( getApplicationContext(), "Has seleccionado " + nombre[+position], Toast.LENGTH_SHORT ).show();
            }
        } );

    }
}
