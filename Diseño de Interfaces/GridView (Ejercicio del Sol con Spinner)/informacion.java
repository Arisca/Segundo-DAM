package com.example.elsol;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class informacion extends AppCompatActivity
{
    private String[] Planetas = new String[9];

    {
        Planetas[0] = "Mercurio";
        Planetas[1] = "Venus";
        Planetas[2] = "La Tierra";
        Planetas[3] = "Marte";
        Planetas[4] = "Jupiter";
        Planetas[5] = "Saturno";
        Planetas[6] = "Urano";
        Planetas[7] = "Neptuno";
        Planetas[8] = "Pluton";
    }

    private String[] Diametro = new String[9];

    {
        Diametro[0] = "0.382";
        Diametro[1] = "0.949";
        Diametro[2] = "1.0";
        Diametro[3] = "0.53";
        Diametro[4] = "11.2";
        Diametro[5] = "9.41";
        Diametro[6] = "3.38";
        Diametro[7] = "3.81";
        Diametro[8] = "????";
    }

    private String[] Distancia = new String[9];

    {
        Distancia[0] = "0.387";
        Distancia[1] = "0.723";
        Distancia[2] = "1.000";
        Distancia[3] = "1.542";
        Distancia[4] = "5203";
        Distancia[5] = "9.539";
        Distancia[6] = "19.81";
        Distancia[7] = "30.07";
        Distancia[8] = "9.44";
    }

    private String[] Densidad = new String[9];

    {
        Densidad[0] = "5400";
        Densidad[1] = "5250";
        Densidad[2] = "5520";
        Densidad[3] = "3960";
        Densidad[4] = "1350";
        Densidad[5] = "700";
        Densidad[6] = "1200";
        Densidad[7] = "1500";
        Densidad[8] = "5???";
    }

    AutoCompleteTextView Planeta1;
    AutoCompleteTextView Planeta2;

    TextView dia1;
    TextView dia2;
    TextView dis1;
    TextView dis2;
    TextView den1;
    TextView den2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_informacion );

        Planeta1 = findViewById( R.id.Planeta1 );
        Planeta2 = findViewById( R.id.Planeta2 );

        final ArrayAdapter<String> Planet = new ArrayAdapter<>( this, android.R.layout.simple_spinner_dropdown_item, Planetas );
        Planeta1.setAdapter( Planet );
        Planeta1.setThreshold( 1 );
        Planeta2.setAdapter( Planet );
        Planeta2.setThreshold( 1 );

        dia1 = findViewById( R.id.dia1 );
        dia2 = findViewById( R.id.dia2 );
        dis1 = findViewById( R.id.dista1 );
        dis2 = findViewById( R.id.dista2 );
        den1 = findViewById( R.id.densi1 );
        den2 = findViewById( R.id.densi2 );


        Planeta1.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

                String Coger = Planeta1.getText().toString();

                int buscar[] = BuscarPlaneta( Coger, Planetas, Diametro, Distancia, Densidad );

                switch (buscar[0]) {
                    case 1:
                        Planetaencontrado( 0, buscar[1], Planetas, Diametro, Distancia, Densidad );
                        break;
                    case 2:
                        Planetanoencontrado();
                        break;
                    default:
                        Planeta1.setHint( "Planeta 1" );
                        break;
                }
            }

            private int[] BuscarPlaneta(String Coger, String [] Planetas, String[] Diametro, String[] Distancia, String[] Densidad)
            {
                int buscar[] = new int[4];

                for (int i = 0; i < 9; i++) {

                    if ( Coger.equals( Planetas[i] ) )
                    {
                        buscar [0] = 1;
                        buscar[1] = i;
                    }
                    else if (Coger.equals (Diametro))
                    {
                        buscar[0] = 1;
                        buscar [2] = i;
                    }
                    else if (Coger.equals (Distancia))
                    {
                        buscar[0] = 2;
                        buscar [3] = i;
                    }
                    else if (Coger.equals (Densidad))
                    {
                        buscar[0] = 3;
                        buscar [4] = i;
                    }
                }
                return buscar;
            }

            private void Planetaencontrado(int buscar, int i, String [] Planetas, String[] Diametro, String[] Distancia, String[] Densidad) {
                if ( buscar == 0 ) {
                    dia1.setText( Diametro[i] );
                    dis1.setText( Distancia[i] );
                    den1.setText( Densidad[i] );

                }
            }
            private void Planetanoencontrado()
            {
                Toast.makeText( getApplicationContext(), "Escoge un Planeta existente", Toast.LENGTH_LONG ).show();
            }
        });

        Planeta2.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

                String Coger = Planeta2.getText().toString();

                int buscar[] = BuscarPlaneta( Coger, Planetas, Diametro, Distancia, Densidad );

                switch (buscar[0]) {
                    case 1:
                        Planetaencontrado( 0, buscar[1], Planetas, Diametro, Distancia, Densidad );
                        break;
                    case 2:
                        Planetanoencontrado();
                        break;
                    default:
                        Planeta2.setHint( "Planeta 1" );
                        break;
                }
            }

            private int[] BuscarPlaneta(String Coger, String [] Planetas, String[] Diametro, String[] Distancia, String[] Densidad)
            {
                int buscar[] = new int[4];

                for (int i = 0; i < 9; i++) {

                    if ( Coger.equals( Planetas[i] ) )
                    {
                        buscar [0] = 1;
                        buscar[1] = i;
                    }
                    else if (Coger.equals (Diametro))
                    {
                        buscar[0] = 1;
                        buscar [2] = i;
                    }
                    else if (Coger.equals (Distancia))
                    {
                        buscar[0] = 2;
                        buscar [3] = i;
                    }
                    else if (Coger.equals (Densidad))
                    {
                        buscar[0] = 3;
                        buscar [4] = i;
                    }
                }
                return buscar;
            }

            private void Planetaencontrado(int buscar, int i, String [] Planetas, String[] Diametro, String[] Distancia, String[] Densidad) {
                if ( buscar == 0 ) {
                    dia2.setText( Diametro[i] );
                    dis2.setText( Distancia[i] );
                    den2.setText( Densidad[i] );

                }
            }
            private void Planetanoencontrado()
            {
                Toast.makeText( getApplicationContext(), "Escoge un Planeta existente", Toast.LENGTH_LONG ).show();
            }
        });
    }

        public boolean onOptionsItemSelected (MenuItem item)
        {
            int menuopcion = item.getItemId();

            if ( menuopcion == R.id.action_settings ) {
                return true;
            } else if ( menuopcion == R.id.action_search ) {
                return true;
            } else if ( menuopcion == R.id.action_info ) {
                Toast.makeText( getApplicationContext(), "Ya te encuentras en la zona de información \n Volviendo al menú principal", Toast.LENGTH_SHORT ).show();

                Intent intent = new Intent( informacion.this, MainActivity.class );
                informacion.this.startActivity( intent );
            }
            return super.onOptionsItemSelected( item );
        }
    }

