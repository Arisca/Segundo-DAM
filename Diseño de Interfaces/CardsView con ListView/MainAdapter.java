package com.example.travel;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainAdapter extends BaseAdapter
{
    private Context context;
    private LayoutInflater inflater;
    private String [] nombre;
    private int [] imagen;

    public MainAdapter(Context c, String [] nombre, int[] imagen)
    {
        context = c;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public int getCount()
    {
        return nombre.length;
    }

    public Object getItem(int position)
    {
        return null;
    }

    public long getItemId(int position)
    {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (inflater == null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        ImageView imageview = convertView.findViewById(R.id.Card);
        TextView textview = convertView.findViewById(R.id.CardName);

        imageview.setImageResource(imagen[position]);
        textview.setText(nombre[position]);

        return convertView;
    }

}
