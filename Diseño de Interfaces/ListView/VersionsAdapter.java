package com.example.playjuegos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class VersionsAdapter extends BaseAdapter
{
    private LayoutInflater mInflater;
    private ArrayList<AndroidVersion> versiones;

    public VersionsAdapter(Context context, ArrayList<AndroidVersion>ver)
    {
        super ();
        this.mInflater = LayoutInflater.from(context);
        this.versiones = ver;
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
        ViewHolder holder;
        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.activity_listausuarios,  parent, false);
            holder = new ViewHolder();
            holder.hNombre = convertView.findViewById(R.id.textNombre);
            holder.hNumero = convertView.findViewById(R.id.textNum);
            holder.hImage = convertView.findViewById(R.id.imagefoto);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        AndroidVersion version = getItem(position);
        holder.hNombre.setText(version.getNombre());
        holder.hNumero.setText(version.getNumero());
        holder.hImage.setImageResource(version.getLogo());
        return convertView;
    }

    class ViewHolder
    {
        TextView hNombre;
        TextView hNumero;
        ImageView hImage;
    }
}
