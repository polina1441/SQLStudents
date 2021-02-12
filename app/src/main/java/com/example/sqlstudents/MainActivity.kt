package com.example.sqlstudents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sqlstudents.database.DBManager
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView

lateinit var name_edit : TextInputEditText
lateinit var discipline_edit : TextInputEditText

lateinit var show_info : MaterialTextView

class MainActivity : AppCompatActivity() {

    val dbManager = DBManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name_edit = findViewById(R.id.name)
        discipline_edit = findViewById(R.id.discipline)
        show_info = findViewById(R.id.show_detail)

        val but_search : MaterialButton = findViewById(R.id.search_but)
        val but_delete : MaterialButton = findViewById(R.id.delete_but)
        val but_add : MaterialButton = findViewById(R.id.add_but)

        but_add.setOnClickListener {
            name_edit.setText("")
            Log.i(TAG, "Save your text")
            show_info.text = name_edit.text.toString()
            dbManager.openDB()
            dbManager.insertDB(name_edit.text.toString(),
                    discipline_edit.text.toString())

            val dataList = dbManager.readDB()
            for (item in dataList){
                name_edit.append(item)
                name_edit.append("\n")
            }
        }

        but_search.setOnClickListener {
            Log.i(TAG, "Click on search")
        }
    }
    companion object{
        val TAG = "TAG: "
    }

    override fun onDestroy() {
        dbManager.closeDB()
        super.onDestroy()

    }

}

