package com.example.spinner

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val role = mutableListOf(
        "Должность",
        "Дизайнер",
        "Тех. дизайнер",
        "Фронт\nразработчик",
        "Бэк\nразработчик",
        "Артдир"
    )
    val persons: MutableList<Person> = mutableListOf()

    private lateinit var toolbarTB: Toolbar
    private lateinit var nameET: EditText
    private lateinit var familyET: EditText
    private lateinit var ageET: EditText
    private lateinit var positionS: Spinner
    private lateinit var addBTN: Button
    private lateinit var personsLV: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        init()

        addBTN.setOnClickListener {
            val name = nameET.text.toString()
            val family = familyET.text.toString()
            val age = ageET.text.toString()
            val person = Person(name, family, age, positionS.getSelectedItem().toString())
            persons.add(person)
            val listAdapter = ListAdapter(this@MainActivity, persons)
            personsLV.adapter = listAdapter
            listAdapter.notifyDataSetChanged()
            clearFields()
        }
    }

    private fun clearFields() {
        nameET.text.clear()
        familyET.text.clear()
        ageET.text.clear()
        positionS.setSelection(0);
    }

    private fun init() {
        toolbarTB = findViewById(R.id.toolbarTB)
        setSupportActionBar(toolbarTB)

        nameET = findViewById(R.id.nameET)
        familyET = findViewById(R.id.familyET)
        ageET = findViewById(R.id.ageET)
        positionS = findViewById(R.id.positionS)
        addBTN = findViewById(R.id.addBTN)

        personsLV = findViewById(R.id.personsLV)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, role)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        positionS.adapter=adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}