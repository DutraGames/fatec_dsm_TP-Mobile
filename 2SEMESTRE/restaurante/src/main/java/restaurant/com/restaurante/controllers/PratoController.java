package restaurant.com.restaurante.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/prato")
public class PratoController {

  @Autowired
  PratoRepository pratoRepository;

  @PostMapping
  public PratoEntity criarPrato(@RequestBody PratoEntity prato) {
    return pratoRepository.save(prato);
  }

  @GetMapping
  public List<PratoEntity> buscarTodosOsPratos() {
    return pratoRepository.findAll();
  }

  @GetMapping("/{id}")
  public PratoEntity buscarUmPrato(@PathVariable int id) {
    return pratoRepository.findById(id).get();
  }

  @DeleteMapping("/{id}")
  public String deletarPrato(@PathVariable int id) {
    pratoRepository.deleteById(id);
    return "Prato deletado";
  }

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
}
