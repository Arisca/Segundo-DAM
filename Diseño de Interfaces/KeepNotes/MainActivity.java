package com.example.keepnotes;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.keepnotes.R.id.fab;

public class MainActivity extends AppCompatActivity
{

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setImageResource(R.drawable.heart);
        fab.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Snackbar.make(view, "Probando...", Snackbar.LENGTH_LONG).show();
                AnimatedVectorDrawable rotar = (AnimatedVectorDrawable) getDrawable(R.drawable.ad_rotation);
                fab.setImageDrawable(rotar);
                rotar.start();
            }
        });

        final ArrayList<Tarjeta> items = new ArrayList<Tarjeta>();
        items.add(new Tarjeta(R.string.note1));
        items.add(new Tarjeta(R.string.note2));
        items.add(new Tarjeta(R.string.note3));
        items.add(new Tarjeta(R.string.note4));
        items.add(new Tarjeta(R.string.note5));
        items.add(new Tarjeta(R.string.note6));

        final RecyclerView recView = (RecyclerView) findViewById(R.id.recyclerView);

        recView.setHasFixedSize(true);


        CardsAdapter adaptador = new CardsAdapter(items);
        recView.setAdapter(adaptador);
        recView.setItemAnimator(new DefaultItemAnimator());
        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adaptador.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "" + recView.getChildAdapterPosition(v), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if ( id == R.id.action_settings )
        {
            return true;
        }
        if ( id == R.id.action_options )
        {
            return true;
        }
        if ( id == R.id.action_search )
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
