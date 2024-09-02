package br.edu.fatecpg.viacep.dao

import android.content.Context
import android.widget.Toast
import br.edu.fatecpg.viacep.interfaces.IEndereco
import br.edu.fatecpg.viacep.interfaces.IViaCEPService
import br.edu.fatecpg.viacep.models.Endereco
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EnderecoDao :IEndereco {

    companion object {
        private var endereco:Endereco? = null
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://viacep.com.br/ws/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(IViaCEPService::class.java)

    override fun ConsultarEndereco(context:Context, cep:String){
                val call = service.consultarCEP(cep)
                call.enqueue(object:Callback<Endereco>{
                    override fun onResponse(chamada: Call<Endereco>, resposta: Response<Endereco>) {
                        if(resposta.isSuccessful){
                            val end = resposta.body()
                            if (end != null && !end.cep.isNullOrEmpty()) {
                                endereco = end
                                Toast.makeText(context, "CEP Localizado!", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(context, "CEP inválido!", Toast.LENGTH_SHORT).show()
                                endereco = null
                            }
                        }
                    }

                    override fun onFailure(chamada: Call<Endereco>, t: Throwable) {
                        println("Erro na requisição: ${t.message}")
                        Toast.makeText(context, "Sem conexão com a Internet!", Toast.LENGTH_SHORT).show()
                    }
        })

    }

    override fun DevolverEndereco(): Endereco {
        println("Retonou os dados!")
        return Companion.endereco?:Endereco()
    }
}