package com.manadigital.recyclerview1.holders

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.manadigital.recyclerview1.R
import com.squareup.picasso.Picasso

class ContactoHolder(v: View) : RecyclerView.ViewHolder(v) {

    private var view: View

    init {
        this.view = v
    }

    fun setName(name: String) {
        val txt: TextView = view.findViewById(R.id.txt_name_item)
        txt.text = name
    }

    fun setEmail(email: String) {
        val txt: TextView = view.findViewById(R.id.txt_email_item)
        txt.text = email
    }

    fun setGravatar(gravatar: String) {
        val imageView = view.findViewById<ImageView>(R.id.gravatarId)
        val imageUrl = gravatar // Reemplaza con la URL de la imagen que deseas mostrar
        Picasso.get()
            .load(imageUrl)
            .into(imageView)
    }

    fun getCardLayout(): CardView {
        return view.findViewById(R.id.card_package_item)
    }

}