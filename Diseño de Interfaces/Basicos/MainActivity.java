package com.example.interfazbsica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v2)
            {
                Intent intentcheck = new Intent(MainActivity.this, actionbars.class);
                MainActivity.this.startActivity(intentcheck);
            }
        });

        b2 = findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v2)
            {
                Intent intentcheck = new Intent(MainActivity.this, textviewandmore.class);
                MainActivity.this.startActivity(intentcheck);
            }
        });

        b3 = findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v2)
            {
                Intent intentcheck = new Intent(MainActivity.this, radiobuttonyratingbar.class);
                MainActivity.this.startActivity(intentcheck);
            }
        });

        b4 = findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v2)
            {
                Intent intentcheck = new Intent(MainActivity.this, chipbuttonscrollview.class);
                MainActivity.this.startActivity(intentcheck);
            }
        });

        b5 = findViewById(R.id.button4);
        b5.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v2)
            {
                Intent intentcheck = new Intent(MainActivity.this, chipbuttonscrollview.class);
                MainActivity.this.startActivity(intentcheck);
            }
        });


    }
}
