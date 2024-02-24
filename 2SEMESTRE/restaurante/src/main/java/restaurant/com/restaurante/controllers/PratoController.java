package restaurant.com.restaurante.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurant.com.restaurante.entities.PratoEntity;
import restaurant.com.restaurante.repository.PratoRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/prato")
public class PratoController {

  @Autowired
  PratoRepository pratoRepository;

  @Operation(
    summary = "Retorna todos os pratos",
    description = "Retorna todos os pratos que possuem no sistema"
  )
  @GetMapping
  public List<PratoEntity> buscarTodosOsPratos() {
    return pratoRepository.findAll();
  }

  @Operation(
    summary = "Retorna um prato",
    description = "Retorna um prato que possuem no sistema"
  )
  @Parameter(name = "id", description = "Id do prato", required = true)
  @GetMapping("/{id}")
  public PratoEntity buscarUmPrato(@PathVariable int id) {
    return pratoRepository.findById(id).get();
  }

  @Operation(
    summary = "Cria um novo prato",
    description = "Cria um novo prato no sistema"
  )
  @Parameter(
    name = "prato",
    description = "Prato a ser criado",
    required = true
  )
  @PostMapping
  public PratoEntity criarPrato(@RequestBody PratoEntity prato) {
    return pratoRepository.save(prato);
  }

  @Operation(
    summary = "Atualiza um prato",
    description = "Atualiza um prato no sistema"
  )
  @Parameter(name = "id", description = "Id do prato", required = true)
  @PutMapping("/{id}")
  public PratoEntity atualizarPrato(
    @PathVariable int id,
    @RequestBody PratoEntity pratoNovo
  ) {
    PratoEntity pratoAtual = pratoRepository.findById(id).get();

    pratoAtual.setNome(pratoNovo.getNome());
    pratoAtual.setPreco(pratoNovo.getPreco());

    return pratoRepository.save(pratoAtual);
  }

  @Operation(
    summary = "Deleta um prato",
    description = "Deleta um prato no sistema"
  )
  @Parameter(name = "id", description = "Id do prato", required = true)
  @DeleteMapping("/{id}")
  public String deletarPrato(@PathVariable int id) {
    pratoRepository.deleteById(id);
    return "Prato deletado";
  }
}
