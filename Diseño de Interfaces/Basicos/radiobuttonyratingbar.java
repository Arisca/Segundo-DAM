package com.example.interfazbsica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class radiobuttonyratingbar extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, RatingBar.OnRatingBarChangeListener {

    RatingBar ratingbar;
    SeekBar seekbar;
    RadioGroup rbjuegos;
    String option;
    FloatingActionButton aceptar;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobuttonyratingbar);


        seekbar = findViewById(R.id.seekbar);
        seekbar.setOnSeekBarChangeListener(radiobuttonyratingbar.this);

        ratingbar = findViewById(R.id.ratingbar);
        ratingbar.setOnRatingBarChangeListener(radiobuttonyratingbar.this);

        rbjuegos = findViewById(R.id.radiogruop);
        rbjuegos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                RadioButton checkedRadioButton = rbjuegos.findViewById(checkedId);
                option = checkedRadioButton.getText().toString();
            }
        });

        aceptar = findViewById(R.id.aceptar);
        aceptar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View view)
            {
                if (option == null)
                {
                    Toast.makeText(radiobuttonyratingbar.this, "No has elegido ningún juego", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(radiobuttonyratingbar.this, "" + option + " Puntuado con un : " + ratingbar.getRating(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
    {
        ratingbar.setRating((float)(progress));
    }

    public void onStartTrackingTouch(SeekBar seekBar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekBar)
    {
    }
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser)
    {
        seekbar.setProgress((int)(rating));
    }
}

