package com.manadigital.recyclerview1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.entities.Contacto
import com.manadigital.recyclerview1.adapters.ContactoListAdapter

class listFragment : Fragment() {

    lateinit var v: View

    lateinit var recContactos : RecyclerView

    var contactos : MutableList<Contacto> = ArrayList<Contacto>()

    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var contactoListAdapter: ContactoListAdapter

    companion object {
        fun newInstance() = listFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        v =  inflater.inflate(R.layout.list_fragment, container, false)

        recContactos = v.findViewById(R.id.rec_contactos)

        return v
    }

    override fun onStart() {
        super.onStart()

        //Creo la Lista Dinamica
        for (i in 1..5) {
            contactos.add(Contacto())
            contactos.add(Contacto())
            contactos.add(Contacto())
            contactos.add(Contacto())
            contactos.add(Contacto())
            contactos.add(Contacto())
            contactos.add(Contacto())
        }

        //Configuración Obligatoria

        recContactos.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)

        recContactos.layoutManager = linearLayoutManager


        contactoListAdapter = ContactoListAdapter(contactos) { x ->
            onItemClick(x)
        }

        recContactos.adapter = contactoListAdapter

    }

     fun onItemClick ( position : Int ) : Boolean{
        Snackbar.make(v,position.toString(),Snackbar.LENGTH_SHORT).show()
         return true
    }



}
