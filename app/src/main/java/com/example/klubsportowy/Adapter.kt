package com.example.klubsportowy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.klubsportowy.model.jsonModelClass
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list.view.*


class UserAdapter(val context: Context, val items: ArrayList<jsonModelClass>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.list,
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items.get(position)

        holder.imie.text = item.imie
        holder.nazwisko.text = item.nazwisko
        holder.wiek.text = item.wiek.toString()
        holder.pozycja.text = item.pozycja
        holder.zdjecie.text = item.zdjecie
        holder.data_zatrudnienia.text = item.data_zatrudnienia
        holder.nr_telefonu.text = item.dane_kontaktowe.nr_telefonu
        holder.adres_email.text = item.dane_kontaktowe.adres_email
        holder.miasto.text = item.adres_zamieszkania.miasto
        holder.ulica.text = item.adres_zamieszkania.ulica
        holder.nr_domu.text = item.adres_zamieszkania.nr_domu
        Picasso.get().load(item.zdjecie).into(holder.imgview)
    }


    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imie = view.imie
        val nazwisko = view.nazwisko
        val wiek = view.wiek
        val pozycja = view.pozycja
        val zdjecie = view.zdjecie
        val data_zatrudnienia = view.data_zatrudnienia
        val nr_telefonu = view.nr_telefonu
        val adres_email = view.adres_email
        val miasto = view.miasto
        val ulica = view.ulica
        val nr_domu = view.nr_domu
        val imgview = view.imageview
    }
}