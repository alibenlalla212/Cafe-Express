package com.example.cafe001

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var qCafe = 0
    var qThe = 0
    var qCroissant = 0

    var prixCafe = 10
    var prixThe = 8
    var prixCroissant = 6

    private lateinit var txtQ_C: TextView
    private lateinit var txtQ_T: TextView
    private lateinit var txtQ_Croissant: TextView
    private lateinit var txtTotal: TextView
    private lateinit var edtNom: EditText

    private lateinit var btnP_C: Button
    private lateinit var btnM_C: Button
    private lateinit var btnP_T: Button
    private lateinit var btnM_T: Button
    private lateinit var btnP_Cr: Button
    private lateinit var btnM_Cr: Button
    private lateinit var btnV: Button
    private lateinit var btnC: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        edtNom = findViewById(R.id.edtNom)
        btnP_C = findViewById(R.id.btnPcafe)
        btnM_C = findViewById(R.id.btnMcafe)
        btnP_T = findViewById(R.id.btnPthe)
        btnM_T = findViewById(R.id.btnMthe)
        btnP_Cr = findViewById(R.id.btnPcroissant)
        btnM_Cr = findViewById(R.id.btnMcroissant)
        btnV = findViewById(R.id.btnVider)
        btnC = findViewById(R.id.btnCommander)
        txtQ_C = findViewById(R.id.txtCafe)
        txtQ_T = findViewById(R.id.txtthe)
        txtQ_Croissant = findViewById(R.id.txtCroissant)
        txtTotal = findViewById(R.id.txtTotal)

        btnP_C.setOnClickListener {
            qCafe = qCafe + 1
            txtQ_C.text = qCafe.toString()
            C_T()
        }

        btnM_C.setOnClickListener {
            if (qCafe > 0) {
                qCafe = qCafe - 1
                txtQ_C.text = qCafe.toString()
                C_T()
            }
        }

        btnP_T.setOnClickListener {
            qThe = qThe + 1
            txtQ_T.text = qThe.toString()
            C_T()
        }

        btnM_T.setOnClickListener {
            if (qThe > 0) {
                qThe = qThe - 1
                txtQ_T.text = qThe.toString()
                C_T()
            }
        }

        btnP_Cr.setOnClickListener {
            qCroissant = qCroissant + 1
            txtQ_Croissant.text = qCroissant.toString()
            C_T()
        }

        btnM_Cr.setOnClickListener {
            if (qCroissant > 0) {
                qCroissant = qCroissant - 1
                txtQ_Croissant.text = qCroissant.toString()
                C_T()
            }
        }

        btnC.setOnClickListener {
            val nom = edtNom.text.toString().trim()

            if (nom.isEmpty()) {
                edtNom.error = "Entrez le nom du client"
                edtNom.requestFocus()
            } else if (qCafe == 0 && qThe == 0 && qCroissant == 0) {
                Toast.makeText(this, "Le panier est vide", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, Main2Activity::class.java)
                intent.putExtra("NOM_CLIENT", nom)
                intent.putExtra("QTE_CAFE", qCafe)
                intent.putExtra("QTE_THE", qThe)
                intent.putExtra("QTE_CROISSANT", qCroissant)
                intent.putExtra("TOTAL", calcul())
                startActivity(intent)
            }
        }

        btnV.setOnClickListener {
            qCafe = 0
            qThe = 0
            qCroissant = 0

            txtQ_C.text = "0"
            txtQ_T.text = "0"
            txtQ_Croissant.text = "0"
            txtTotal.text = "Total : 0 DH"

            edtNom.setText("")
            edtNom.error = null

            Toast.makeText(this, "Commande annulée", Toast.LENGTH_SHORT).show()
        }
    }

    private fun calcul(): Int {
        return qCafe * prixCafe + qThe * prixThe + qCroissant * prixCroissant
    }

    private fun C_T() {
        txtTotal.text = "Total : ${calcul()} DH"
    }
}
