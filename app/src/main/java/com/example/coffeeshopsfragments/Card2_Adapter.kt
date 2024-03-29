package com.example.coffeeshopsfragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshops.Card
import com.example.coffeeshops.Card_Adapter

class Card2_Adapter(var items: ArrayList<Card2>) :
    RecyclerView.Adapter<Card2_Adapter.TarjViewHolder>() {

        lateinit var onClick: (View) -> Unit

        init {
            this.items = items
        }

        class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


            private var texto: TextView

            init {
                texto = itemView.findViewById(R.id.text_id)
            }

            fun bindTarjeta(t: Card2, onClick: (View) -> Unit) = with(itemView) {
                texto.setText(t.texto)
                setOnClickListener { onClick(itemView) }
            }
        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
            val itemView =
                LayoutInflater.from(viewGroup.context).inflate(R.layout.card2_item, viewGroup, false)
            return TarjViewHolder(itemView)
        }

        override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
            val item = items.get(pos)
            viewHolder.bindTarjeta(item, onClick)

        }

        override fun getItemCount(): Int {
            return items.size
        }
    }