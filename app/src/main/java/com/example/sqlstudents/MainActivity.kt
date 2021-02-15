package com.example.sqlstudents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sqlstudents.database.DBClass
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
        val but_show : MaterialButton = findViewById(R.id.show_but)
        val but_add : MaterialButton = findViewById(R.id.add_but)
        val but_delete_db : MaterialButton = findViewById(R.id.delete_db)

        but_add.setOnClickListener {
            dbManager.openDB()
            dbManager.insertDB(name_edit.text.toString(),
                    discipline_edit.text.toString())
        }

        but_show.setOnClickListener {
            if (show_info.text != ""){
                show_info.text = ""
            }
            val dataList = dbManager.readDB()
            for (item in dataList){
                show_info.append(item)
                show_info.append("\n")
            }
        }
        but_delete_db.setOnClickListener {
            dbManager.deleteDB()
        }
        but_search.setOnClickListener {
            recording  = name_edit.text.toString()

        }
    }
    companion object{
        val TAG = "TAG: "
        var recording =""
    }

    override fun onDestroy() {
        dbManager.closeDB()
        super.onDestroy()

    }

}

