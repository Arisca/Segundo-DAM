package com.example.interfazbsica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class actionbars extends AppCompatActivity
{
    FloatingActionButton fab;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbars);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Snackbar.make(view, "El botón se desplaza hacia arriba", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });


    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_search:return true;
            case R.id.action_add:return true;
            default:return super.onOptionsItemSelected(item);
        }
    }
}
