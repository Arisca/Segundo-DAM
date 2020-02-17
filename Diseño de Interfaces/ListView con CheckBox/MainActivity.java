package com.example.deportes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.net.CookieHandler;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    FloatingActionButton fab;

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater(); inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_search:
                return true;
            case R.id.action_add:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Androidversion> versiones = new ArrayList<Androidversion>();
        versiones.add(new Androidversion("Baloncesto", R.mipmap.baloncesto));
        versiones.add(new Androidversion("Beisbol", R.mipmap.beisbol));
        versiones.add(new Androidversion("Ciclismo", R.mipmap.ciclismo));
        versiones.add(new Androidversion("Fútbol", R.mipmap.futbol));
        versiones.add(new Androidversion("Golf", R.mipmap.golf));
        versiones.add(new Androidversion("Hípica", R.mipmap.hipica));
        versiones.add(new Androidversion("Natación", R.mipmap.natacion));
        versiones.add(new Androidversion("Pin Pon", R.mipmap.pinpon));
        versiones.add(new Androidversion("Tenis", R.mipmap.tenis));

        final ListView lista_versiones = (ListView) findViewById(R.id.ListaDeportes);
        final Versionesadapter adapter = new Versionesadapter(MainActivity.this, versiones);
        lista_versiones.setAdapter(adapter);

        fab = findViewById(R.id.aceptar);
        fab.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

            }

        });
    }
}
