package com.example.klubsportowy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.klubsportowy.databinding.CellBinding
import com.squareup.picasso.Picasso

class RVAdapter(private val list: ArrayList<List>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class CellViewHolder(var viewBinding: CellBinding) : RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = CellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CellViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder = holder as CellViewHolder
        itemViewHolder.viewBinding.imie.text = list[position].playername
        itemViewHolder.viewBinding.nazwisko.text = list[position].playersurname
        itemViewHolder.viewBinding.wiek.text = list[position].playerage.toString()
        itemViewHolder.viewBinding.pozycja.text = list[position].playerposition
        itemViewHolder.viewBinding.nardowosc.text = list[position].playercountry
        itemViewHolder.viewBinding.mecze.text = list[position].mecze.toString()
        itemViewHolder.viewBinding.gole.text = list[position].gole.toString()
        itemViewHolder.viewBinding.asysty.text = list[position].asysty.toString()
        Picasso.get().load(list[position].playerimg).into(itemViewHolder.viewBinding.imageview)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}