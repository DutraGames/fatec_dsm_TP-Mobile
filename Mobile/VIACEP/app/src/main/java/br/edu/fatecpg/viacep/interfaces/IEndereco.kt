package br.edu.fatecpg.viacep.interfaces

import br.edu.fatecpg.viacep.models.Endereco

interface IEndereco {
    fun ConsultarEndereco(cep:String)
    fun DevolverEndereco():Endereco
}