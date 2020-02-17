package com.example.segundaevaluacion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment

class pagina2 : Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.pagina2, container, false)

        val versiones = ArrayList<AndroidVersion>()
        versiones.add(AndroidVersion("Erika", "967", R.drawable.imagen1))
        versiones.add(AndroidVersion("Ivan", "945", R.drawable.imagen2))
        versiones.add(AndroidVersion("Akire", "967", R.drawable.imagen3))
        versiones.add(AndroidVersion("Chop Suey", "945", R.drawable.imagen4))
        versiones.add(AndroidVersion("Esther", "967", R.drawable.imagen5))
        versiones.add(AndroidVersion("ATWA", "945", R.drawable.imagen6))

        val lstOpciones = rootView.findViewById(R.id.Listview) as ListView

        val adaptador = VersionesAdapter(activity!!, versiones)
        lstOpciones.adapter = adaptador

        return rootView
    }
}
