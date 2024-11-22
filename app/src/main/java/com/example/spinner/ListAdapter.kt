package com.example.spinner

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter(context: Context, personList: MutableList<Person>) :
    ArrayAdapter<Person>(context, R.layout.person_list_item, personList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val person = getItem(position)
        if (view == null) view =
            LayoutInflater.from(context).inflate(R.layout.person_list_item, parent, false)

        val nameTV = view?.findViewById<TextView>(R.id.nameTV)
        val familyTV = view?.findViewById<TextView>(R.id.familyTV)
        val ageTV = view?.findViewById<TextView>(R.id.ageTV)
        val positionTV = view?.findViewById<TextView>(R.id.positionTV)

        nameTV?.text = person?.name
        familyTV?.text = person?.family
        ageTV?.text = person?.age
        positionTV?.text = person?.position

        return view!!
    }
}