package com.example.playjuegos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class Games<checkbox> extends AppCompatActivity
{

    private CheckBox [] checkbox;
    private ArrayList <String> checknames;
    private String result;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        checkbox = new CheckBox [6];
        checkbox [0] = findViewById (R.id.checkangry);
        checkbox [1] = findViewById (R.id.checkdragon);
        checkbox [2] = findViewById (R.id.checkill);
        checkbox [3] = findViewById (R.id.checkradiant);
        checkbox [4] = findViewById (R.id.checkair);
        checkbox [5] = findViewById (R.id.checkninja);

        FloatingActionButton fab = findViewById(R.id.aceptar);
        fab.setOnClickListener(new View.OnClickListener()
        {
           public void onClick (View view)
           {
               checknames = new ArrayList <String>();
               for (int i = 0; i < checkbox.length; i ++)
               {
                   if (checkbox [i].isChecked())
                   {
                       checknames.add(checkbox[i].getText().toString());
                   }
               }
               if (checknames.size()==0)
               {
                   result = "Debes seleccionar algún juego";
               }
               else
               {
                   for (int i=0; i<checknames.size(); i ++)
                   {
                       if (i==0)
                       {
                           result = "Has seleccionado " + checknames.get(0);
                       }
                       else
                           if (i == checknames.size() -1)
                           {
                               result += " y "+ checknames.get(i);
                           }
                           else
                           {
                               result +=", "+checknames.get(i);
                           }
                   }
               }
               Toast.makeText(getApplicationContext(),result,
                       Toast.LENGTH_LONG).show();
           }
        });


    }
}
