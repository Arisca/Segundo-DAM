package com.example.deportes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Versionesadapter extends BaseAdapter
{

    private LayoutInflater mInflater;
    private ArrayList <Androidversion> versiones;

    public Versionesadapter(Context context, ArrayList< Androidversion> vers) {
        super();
        this.mInflater = LayoutInflater.from(context);
        this.versiones = vers;
    }

    public int getCount() {
        return versiones.size();
    }
    public Androidversion getItem(int position)
    {
        return versiones.get(position);
    }
    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder = null;
        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.lista_deportes, null);
            holder = new ViewHolder();
            holder.hNombre = (TextView) convertView.findViewById(R.id.idNombre);
            holder.hImage = (ImageView) convertView.findViewById(R.id.idImage);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        Androidversion version = getItem(position);
        holder.hNombre.setText(version.getNombre());
        holder.hImage.setImageResource(version.getLogo());
        return convertView;
    }

    class ViewHolder
    {
        TextView hNombre;
        ImageView hImage;
    }
}
