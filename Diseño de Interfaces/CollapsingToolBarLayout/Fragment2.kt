package com.example.travel

import android.app.Activity
import android.os.Bundle
import android.view.*
import android.view.ContextMenu.ContextMenuInfo
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView


class Fragment2() : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.activity_fragment2, container, false)

        val versiones = ArrayList<AndroidVersion>()
        versiones.add(AndroidVersion("Maria Mata", "2014", com.example.travel.R.drawable.whale))
        versiones.add(AndroidVersion("Antonio Sanz", "1890", com.example.travel.R.drawable.whale2))
        versiones.add(AndroidVersion("Carlos", "967", com.example.travel.R.drawable.whale3))
        versiones.add(AndroidVersion("Berta", "945", com.example.travel.R.drawable.whale4))
        versiones.add(AndroidVersion("Héctor Campos", "879", com.example.travel.R.drawable.whale5))
        versiones.add(AndroidVersion("Ismael", "678", com.example.travel.R.drawable.whale6))
        versiones.add(AndroidVersion("Iván García", "567", com.example.travel.R.drawable.whale7))
        versiones.add(AndroidVersion("Erika García", "2019", com.example.travel.R.drawable.whale8))

        val lstOpciones = rootView.findViewById(R.id.Listview) as ListView
        registerForContextMenu(lstOpciones)

        val adaptador = VersionesAdapter(activity!!, versiones)
        lstOpciones.adapter = adaptador
        registerForContextMenu(lstOpciones)

        return rootView
    }
}

class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    init {
        itemView.setOnLongClickListener { view ->
            (view.context as AppCompatActivity).startSupportActionMode(modeCallBack)
            return@setOnLongClickListener true
        }
    }

        var modeCallBack: ActionMode.Callback = object : ActionMode.Callback {
            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                val id = item?.itemId
                when (id) {
                    R.id.Editar -> {
                        Toast.makeText(itemView.context, "Editando", Toast.LENGTH_SHORT).show()
                        mode?.finish()
                    }
                    R.id.Eliminar -> {
                        Toast.makeText(itemView.context, "Eliminando", Toast.LENGTH_SHORT).show()
                        mode?.finish()
                    }
                    R.id.Compartir -> {
                        Toast.makeText(itemView.context, "Compartiendo", Toast.LENGTH_SHORT).show()
                        mode?.finish()
                    }
                    else -> return false
                }
                return false
            }

            override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
                return false
            }

            override fun onDestroyActionMode(mode: ActionMode?) {
                var mode = mode
                mode = null
            }

            override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
                mode.setTitle("Options")
                mode.getMenuInflater().inflate(R.menu.menu_context, menu)
                return true
            }
        }
    }











