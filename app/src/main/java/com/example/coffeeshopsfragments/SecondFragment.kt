package com.example.coffeeshopsfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshops.Card
import com.example.coffeeshops.Card_Adapter


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val texto: TextView = view.findViewById(R.id.titulo)
        texto.text = arguments?.getString("NOM")

        val items = ArrayList<Card2>()
        items.add(Card2(R.string.comentario1))
        items.add(Card2(R.string.comentario2))
        items.add(Card2(R.string.comentario3))
        items.add(Card2(R.string.comentario4))
        items.add(Card2(R.string.comentario5))


        val recView = view.findViewById<RecyclerView>(R.id.recview2)

        recView.setHasFixedSize(true)

        val adaptador = Card2_Adapter(items)
        recView.adapter = adaptador
        recView.layoutManager = GridLayoutManager(context,2)


        adaptador.onClick = {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}