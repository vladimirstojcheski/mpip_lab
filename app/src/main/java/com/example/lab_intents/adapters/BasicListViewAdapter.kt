package com.example.lab_intents.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.lab_intents.R

class BasicListViewAdapter(val context: Context, val classes: MutableList<String>) : BaseAdapter() {

    private var layoutInflator: LayoutInflater


    init {
        layoutInflator = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return classes.size
    }

    override fun getItem(position: Int): Any {

        return classes[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        val view: View?

        if(convertView == null) {


            view = layoutInflator.inflate(R.layout.basic_list_view, null, false)

            val currentClassName = classes[position]

            val className = view.findViewById<TextView>(R.id.listTextView)

            className.setText(currentClassName.toString())
        }
        else{
            view = convertView
        }

        return view

    }
}