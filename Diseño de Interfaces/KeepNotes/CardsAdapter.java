package com.example.keepnotes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.TarjViewHolder> implements View.OnClickListener
{
    private static ArrayList<Tarjeta> items;
    private View.OnClickListener listener;
    public CardsAdapter(ArrayList<Tarjeta> items)
    {
        this.items = items;
    }


    public class TarjViewHolder extends RecyclerView.ViewHolder
    {
        private TextView texto;

        public TarjViewHolder(View itemView)
        {
            super(itemView);
            texto = (TextView) itemView.findViewById(R.id.txt1);
        }

        public void bindTitular(Tarjeta t)
        {
            texto.setText(t.getTexto());
        }
    }

    public TarjViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_item_cards, viewGroup, false);
        itemView.setOnClickListener(this);
        TarjViewHolder tvh = new TarjViewHolder(itemView);
        return tvh;
    }

    public void onBindViewHolder(TarjViewHolder viewHolder, int pos)
    {
        Tarjeta item = items.get(pos);
        viewHolder.bindTitular(item);
    }

    public int getItemCount()
    {
        return items.size();
    }

    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener = listener;
    }

    public void onClick (View view)
    {
        if (listener != null)
        {
            listener.onClick(view);
        }
    }
}

