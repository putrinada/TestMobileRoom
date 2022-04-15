package com.adl.testmobileroom

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.adl.testmobileroom.database.DataBase
import com.adl.testmobileroom.database.model.DataModel
import kotlinx.android.synthetic.main.activity_add_data.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data)

        val spinner: Spinner = findViewById(R.id.spinner)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.spinner,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter


        }

        val spinner2: Spinner = findViewById(R.id.spinner2)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.spinner2,
            android.R.layout.simple_spinner_item
        ).also { adapter2 ->
            // Specify the layout to use when the list of choices appears
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner2.adapter = adapter2

        }

        btnSend.setOnClickListener({
            val data = DataModel(0,txtNama.text.toString(),txtUmur.text.toString(),
                txtlocation.text.toString())

            GlobalScope.launch {
                DataBase.getInstance(this@AddData).dataDao().insertData(data)

                val intent = Intent()
                intent.putExtra("data",data)
                setResult(Activity.RESULT_OK,intent)
                finish()
            }

        })
    }
}
