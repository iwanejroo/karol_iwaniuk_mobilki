package com.example.klubsportowy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.klubsportowy.databinding.CellBinding
import com.squareup.picasso.Picasso

class RVAdapter(private val cell: ArrayList<Cell>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class CellViewHolder(var viewBinding: CellBinding) : RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = CellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CellViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder = holder as CellViewHolder
        itemViewHolder.viewBinding.imie.text = cell[position].playername
        itemViewHolder.viewBinding.nazwisko.text = cell[position].playersurname
        itemViewHolder.viewBinding.wiek.text = cell[position].playerage.toString()
        itemViewHolder.viewBinding.pozycja.text = cell[position].playerposition
        itemViewHolder.viewBinding.nardowosc.text = cell[position].playercountry
        itemViewHolder.viewBinding.mecze.text = cell[position].mecze.toString()
        itemViewHolder.viewBinding.gole.text = cell[position].gole.toString()
        itemViewHolder.viewBinding.asysty.text = cell[position].asysty.toString()
        Picasso.get().load(cell[position].playerimg).into(itemViewHolder.viewBinding.imageview)

    }

    override fun getItemCount(): Int {
        return cell.size
    }
}