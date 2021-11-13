package com.example.lab_intents

import android.content.Intent
import android.content.pm.ResolveInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.lab_intents.adapters.BasicListViewAdapter

class ImplicitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit)

        val data :MutableList<String> = getActivities()

        val listViewComponent = findViewById<ListView>(R.id.listViewId)

        // val itemsAdapter = BasicListViewAdapter(this, data)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)

        listViewComponent.adapter = adapter
    }



    private fun getActivities(): MutableList<String> {
        val resultList: ArrayList<String> = ArrayList()
        val mainIntent = Intent(Intent.ACTION_MAIN, null)
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER)
        val resolveInfos: List<ResolveInfo> =
            packageManager.queryIntentActivities(mainIntent, 0)
        for(info in resolveInfos){
            if(info.activityInfo.name != null){
                resultList.add(info.activityInfo.name.toString())
            }
        }

        return resultList
    }
}