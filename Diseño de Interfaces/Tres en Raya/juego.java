package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class juego extends AppCompatActivity implements View.OnClickListener
{

    private TextView J1;
    private TextView J2;
    private TextView puntuacion1;
    private TextView puntuacion2;
    private Button reset;

    private Button [][] buttons = new Button [3] [3];
    private boolean player1Turn = true;
    private int roundCount;
    private int player1Points;
    private int player2Points;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_juego );

    Intent nombres = getIntent();
    Bundle b = nombres.getExtras();

    String jugador1 = b.getString ("jugador1");
    String jugador2 = b.getString ("jugador2");
    J1 = findViewById( R.id.Jugador1 );
    J2 = findViewById( R.id.Jugador2 );
    J1.setText(jugador1);
    J2.setText(jugador2);

    puntuacion1 = findViewById( R.id.Puntuacion1 );
    puntuacion2 = findViewById( R.id.Puntuacion2 );

    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            String ButtonID = "b_" +i +j;
            int resID = getResources().getIdentifier( ButtonID,"id", getPackageName());
            buttons [i] [j] = findViewById( resID );
            buttons [i] [j].setOnClickListener( this );
        }
    }

        reset = findViewById( R.id.reset );
        reset.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View v)
            {
                player1Points = 0;
                player2Points = 0;
                updatePointsText();
                resetBoard();
            }
        });
    }

    public void onClick(View v)
    {
        if (!((Button) v).getText().toString().equals(""))
        {
            return;
        }

        if (player1Turn)
        {
            ((Button) v).setText("X");
        }
        else
        {
            ((Button) v).setText("O");
        }

        roundCount ++;

        if (checkForWin())
        {
            if (player1Turn)
            {
                player1Wins();
            }
            else
            {
                player2Wins();
            }
        }
        else if (roundCount == 9)
        {
            draw ();
        }
        else
        {
            player1Turn = !player1Turn;

        }
    }

    private boolean checkForWin() {
        String[][] field = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }
        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals( field[i][1] )
                    && field[i][0].equals( field[i][2] )
                    && !field[i][0].equals( "" )) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals( field[1][i] )
                    && field[0][i].equals( field[2][i] )
                    && !field[0][i].equals( "" )) {
                return true;
            }
        }
        if (field[0][0].equals( field[1][1] )
                && field[0][0].equals( field[2][2] )
                && !field[0][0].equals( "" )) {
            return true;
        }
        if (field[0][2].equals( field[1][1] )
                && field[0][2].equals( field[2][0] )
                && !field[0][2].equals( "" )) {
            return true;
        }
        return false;
    }

    private void player1Wins()
    {
        player1Points++;
        Toast.makeText(this, "Y el ganador es "+J1.getText().toString(), Toast.LENGTH_SHORT ).show();
        updatePointsText();
        resetBoard();
    }

    private void player2Wins()
    {
        player2Points++;
        Toast.makeText(this, "Y el ganador es "+J2.getText().toString(), Toast.LENGTH_SHORT ).show();
        updatePointsText();
        resetBoard();
    }

    private void draw()
    {
        Toast.makeText (this, "EMPATE", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void updatePointsText()
    {
        puntuacion1.setText("P : " +player1Points);
        puntuacion2.setText("P : " +player2Points);
    }

    private void resetBoard()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j ++)
            {
                buttons [i] [j].setText("");
            }
        }
    }
}
