package com.example.cafe001

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty2)

        val txtClient: TextView = findViewById(R.id.txtRClient)
        val txtCafe: TextView = findViewById(R.id.txtRCafe)
        val txtThe: TextView = findViewById(R.id.txtRThe)
        val txtCroissant: TextView = findViewById(R.id.txtRCr)
        val txtTotal: TextView = findViewById(R.id.txtRTotal)
        val btnM: Button = findViewById(R.id.btnM)
        val btnC: Button = findViewById(R.id.btnC)

        val nom = intent.getStringExtra("NOM_CLIENT")
        val qCafe = intent.getIntExtra("QTE_CAFE", 0)
        val qThe = intent.getIntExtra("QTE_THE", 0)
        val qCroissant = intent.getIntExtra("QTE_CROISSANT", 0)
        val total = intent.getIntExtra("TOTAL", 0)

        txtClient.text = "Client : $nom"
        txtCafe.text = "Café : $qCafe × 10 DH = ${qCafe * 10} DH"
        txtThe.text = "Thé : $qThe × 8 DH = ${qThe * 8} DH"
        txtCroissant.text = "Croissant : $qCroissant × 6 DH = ${qCroissant * 6} DH"
        txtTotal.text = "Total : $total DH"

        btnM.setOnClickListener {
            finish()
        }

        btnC.setOnClickListener {
            Toast.makeText(this, "Commande de $nom envoyée en cuisine", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
