package br.edu.fatecpg.viacep.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.viacep.R
import br.edu.fatecpg.viacep.dao.EnderecoDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ConsultarCEPActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar_cepactivity)

        val enderecoDao = EnderecoDao()
        val edtCEP = findViewById<EditText>(R.id.edt_CEP)
        val btnSave = findViewById<Button>(R.id.btn_save)
        val fabTrans = findViewById<FloatingActionButton>(R.id.fab_trans)

        btnSave.setOnClickListener(){

            enderecoDao.ConsultarEndereco(edtCEP.text.toString())

        }

        fabTrans.setOnClickListener(){
            val trasicao = Intent(this,ResultadoActivity::class.java)
            startActivity(trasicao)
        }


    }
}