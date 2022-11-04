package com.example.coffeeshopsfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshops.Card
import com.example.coffeeshops.Card_Adapter


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = ArrayList<Card>()
        items.add(Card(R.mipmap.images, R.string.anticoCaffe, R.string.italy))
        items.add(Card(R.mipmap.images1, R.string.coffeRoom, R.string.germany))
        items.add(Card(R.mipmap.images2, R.string.coffeIbiza, R.string.colon))
        items.add(Card(R.mipmap.images3, R.string.puddingCoffe, R.string.diagonal))
        items.add(Card(R.mipmap.images4, R.string.express, R.string.picadilly))
        items.add(Card(R.mipmap.images5, R.string.coffeCorner, R.string.angelGuimera))
        items.add(Card(R.mipmap.images6, R.string.sweetCup, R.string.kinkerstraat))

        val recView = view.findViewById<RecyclerView>(R.id.recview)

        recView.setHasFixedSize(true)

        val adaptador = Card_Adapter(items)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)


        adaptador.onClick = {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}