package br.edu.fatecpg.consumoapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Endereco(@JsonAlias("cep") String cep,
                      @JsonAlias("logradouro")String rua,
                      @JsonAlias("bairro")String bairro,
                      @JsonAlias("localidade")String cidade,
                      @JsonAlias("uf")String estado) {
    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
