package br.edu.fatecpg.viacep.views

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.viacep.R
import br.edu.fatecpg.viacep.dao.EnderecoDao
import br.edu.fatecpg.viacep.models.Endereco

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val enderecoDao = EnderecoDao()
        val endereco:Endereco = enderecoDao.DevolverEndereco()

        val txtCep = findViewById<TextView>(R.id.txt_cep)
        val txtLogadouro = findViewById<TextView>(R.id.txt_long)
        val txtBairro = findViewById<TextView>(R.id.txt_bairro)
        val txtLocalidade = findViewById<TextView>(R.id.txt_local)

        txtCep.text = "CEP: ${endereco.cep}"
        txtLogadouro.text = "Rua: ${endereco.logradouro}"
        txtBairro.text = "Bairro: ${endereco.bairro}"
        txtLocalidade.text = "Cidade: ${endereco.localidade}"

    }
}