package restaurant.com.restaurante.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.websocket.server.PathParam;
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
import restaurant.com.restaurante.entities.MesaEntity;
import restaurant.com.restaurante.repository.MesaRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/mesas")
public class MesaController {

  @Autowired
  MesaRepository mesaRepository;

  @Operation(
    summary = "Retorna todas as mesas",
    description = "Retorna todas as mesas que possuem no sistema"
  )
  @GetMapping
  public List<MesaEntity> buscarTodasAsMesas() {
    return mesaRepository.findAll();
  }

  @Operation(
    summary = "Retorna uma mesa",
    description = "Retorna uma mesa pelo seu id"
  )
  @Parameter(name = "id", description = "Id da mesa", required = true)
  @GetMapping("/{id}")
  public MesaEntity buscarUmaMesa(@PathVariable("id") int id) {
    return mesaRepository.findById(id).get();
  }

  @Operation(
    summary = "Cria uma mesa",
    description = "Cria uma mesa no sistema"
  )
  @Parameter(name = "mesa", description = "Mesa a ser criada", required = true)
  @PostMapping
  public MesaEntity criarMessa(@RequestBody MesaEntity mesa) {
    return mesaRepository.save(mesa);
  }

  @Operation(
    summary = "Atualiza uma mesa",
    description = "Atualiza uma mesa no sistema"
  )
  @Parameter(name = "id", description = "Id da mesa", required = true)
  @PutMapping("/{id}")
  public MesaEntity atualizarMesa(
    @PathVariable("id") int id,
    @RequestBody MesaEntity mesa
  ) {
    MesaEntity mesaAtual = mesaRepository.findById(id).get();
    mesaAtual.setNumero(mesa.getNumero());
    return mesaRepository.save(mesaAtual);
  }

  @Operation(
    summary = "Ocupa uma mesa",
    description = "Ocupa uma mesa no sistema"
  )
  @Parameter(name = "id", description = "Id da mesa", required = true)
  @PutMapping("/ocupar/{id}")
  public MesaEntity ocuparMesa(
    @PathVariable("id") int id,
    @RequestBody MesaEntity mesa
  ) {
    MesaEntity mesaAtual = mesaRepository.findById(id).get();
    mesaAtual.setLivre(false);
    return mesaRepository.save(mesaAtual);
  }

  @Operation(
    summary = "Deleta uma mesa",
    description = "Deleta uma mesa no sistema"
  )
  @Parameter(name = "id", description = "Id da mesa", required = true)
  @DeleteMapping("/{id}")
  public String deletarMesa(@PathVariable("id") int id) {
    mesaRepository.deleteById(id);
    return "Mesa deletada";
  }
}
