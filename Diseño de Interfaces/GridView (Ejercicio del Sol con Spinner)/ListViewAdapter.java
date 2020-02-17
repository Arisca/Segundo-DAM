package com.example.elsol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class ListViewAdapter {
    Context context;
    LayoutInflater inflater;
    private List<ListaPlanetas> planetasList = null;
    private ArrayList<ListaPlanetas> arrayplanetas;

    public ListViewAdapter(Context context, List<ListaPlanetas> planetasList) {
        context = context;
        this.planetasList = planetasList;
        inflater = LayoutInflater.from( context );
        this.arrayplanetas = new ArrayList<ListaPlanetas>();
        this.arrayplanetas.addAll( planetasList );
    }

    public class ViewHolder {
        AutoCompleteTextView planetas;
        TextView diametro;
        TextView distancia;
        TextView densidad;
    }

    public int getCount() {
        return planetasList.size();
    }

    public ListaPlanetas getItem(int position) {
        return planetasList.get( position );
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            holder.planetas = view.findViewById( R.id.Planeta1 );
            holder.planetas = view.findViewById( R.id.Planeta2 );
            holder.distancia = view.findViewById( R.id.dista1 );
            holder.distancia = view.findViewById( R.id.dista2 );
            holder.diametro = view.findViewById( R.id.dia1 );
            holder.diametro = view.findViewById( R.id.dia2 );
            holder.densidad = view.findViewById( R.id.densi1 );
            holder.densidad = view.findViewById( R.id.densi2 );
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.planetas.setText( planetasList.get( position ).getPlanetas() );
        holder.diametro.setText( planetasList.get( position ).getDiametro() );
        holder.distancia.setText( planetasList.get( position ).getDistancia() );
        holder.densidad.setText( planetasList.get( position ).getDensidad() );

        return view;
    }
}





