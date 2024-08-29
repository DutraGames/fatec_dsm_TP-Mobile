package br.edu.fatecpg.viacep.dao

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

    override fun ConsultarEndereco(cep:String){
                val call = service.consultarCEP(cep)
                call.enqueue(object:Callback<Endereco>{
                    override fun onResponse(chamada: Call<Endereco>, resposta: Response<Endereco>) {
                        if(resposta.isSuccessful){
                            endereco = resposta.body()
                            println("Endereço: $endereco")
                        }else{
                            println("Erro na resposta: ${resposta.code()}")
                        }
                    }

                    override fun onFailure(chamada: Call<Endereco>, t: Throwable) {
                        println("Erro na requisição: ${t.message}")
                    }
        })

    }

    override fun DevolverEndereco(): Endereco {
        println("Retonou os dados!")
        return Companion.endereco?:Endereco()
    }
}