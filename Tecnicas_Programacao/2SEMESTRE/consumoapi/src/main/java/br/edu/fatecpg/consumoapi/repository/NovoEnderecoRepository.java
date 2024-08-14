package br.edu.fatecpg.consumoapi.repository;

import br.edu.fatecpg.consumoapi.model.NovoEndereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovoEnderecoRepository extends JpaRepository<NovoEndereco, Long> {

	Object findByCep(String cep);

}
