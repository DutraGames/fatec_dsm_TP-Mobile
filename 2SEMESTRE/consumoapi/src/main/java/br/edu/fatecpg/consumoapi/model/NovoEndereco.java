package br.edu.fatecpg.consumoapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "enderecos")
public class NovoEndereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    @Column(name = "uf")
    private String estado;

    public NovoEndereco(){}

    public NovoEndereco(Endereco endereco) {
        this.cep = endereco.cep();
        this.rua = endereco.rua();
        this.bairro = endereco.bairro();
        this.cidade = endereco.cidade();
        this.estado = endereco.estado();
    }



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
