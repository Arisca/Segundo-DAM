package com.example.travel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class VersionesAdapter extends BaseAdapter
{
    private LayoutInflater li;
    private ArrayList<AndroidVersion> versiones;
    private Context context;
    private String [] CardName;
    private int [] Cards;


    public VersionesAdapter(Context c, String[] CardName, int[] Cards)
    {
        context = c;
        this.CardName = CardName;
        this.Cards = Cards;
    }

    public int getCount()
    {
        return versiones.size();
    }

    public AndroidVersion getItem(int position)
    {
        return versiones.get(position);
    }

    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        convertView = li.inflate (R.layout.list_item, null);
        CardView hImagen = convertView.findViewById (R.id.Card);
        TextView hNombre = convertView.findViewById (R.id.CardName);

        AndroidVersion version = getItem (position);
        hImagen.setCardBackgroundColor(version.getImagen());
        hNombre.setText(version.getNombre());

        return convertView;
    }

    class ViewHolder
    {
        CardView hImage;
        TextView hNombre;
    }
}
