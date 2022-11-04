package com.example.coffeeshops

import android.view.*
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshopsfragments.R

class Card_Adapter(var items: ArrayList<Card>) :
    RecyclerView.Adapter<Card_Adapter.TarjViewHolder>() {
    lateinit var onClick: (View) -> Unit

    init {
        this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var imagen: ImageView
        private var nombre: TextView
        private var lugar: TextView
        var ratingBar: RatingBar
        var puntuacion: TextView

        init {
            imagen = itemView.findViewById(R.id.imgPrincipal)
            nombre = itemView.findViewById(R.id.textNombre)
            lugar = itemView.findViewById(R.id.textLugar)
            ratingBar = itemView.findViewById(R.id.ratingEstrellas)
            puntuacion = itemView.findViewById(R.id.puntuacion)
        }

        fun bindTarjeta(t: Card, onClick: (View) -> Unit) = with(itemView) {
            imagen.setImageResource(t.imagen)
            nombre.setText(t.nombre)
            lugar.setText(t.lugar)
            setOnClickListener { onClick(itemView) }


        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.card_item, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindTarjeta(item, onClick)

        val ratingBarSelected = viewHolder.ratingBar
        val puntuacionSelected = viewHolder.puntuacion
        ratingBarSelected.onRatingBarChangeListener =
            RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
                puntuacionSelected.text = rating.toString()
            }
    }

    override fun getItemCount(): Int {
        return items.size
    }


}