package restaurant.com.restaurante.controllers;

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

  @GetMapping
  public List<MesaEntity> buscarTodasAsMesas() {
    return mesaRepository.findAll();
  }

  @PostMapping
  public MesaEntity criarMessa(@RequestBody MesaEntity mesa) {
    return mesaRepository.save(mesa);
  }

  @GetMapping("/{id}")
  public MesaEntity buscarUmaMesa(@PathVariable("id") int id) {
    return mesaRepository.findById(id).get();
  }

  @PutMapping("/{id}")
  public MesaEntity atualizarMesa(
    @PathVariable("id") int id,
    @RequestBody MesaEntity mesa
  ) {
    MesaEntity mesaAtual = mesaRepository.findById(id).get();
    mesaAtual.setNumero(mesa.getNumero());
    return mesaRepository.save(mesaAtual);
  }

  @PutMapping("/ocupar/{id}")
  public MesaEntity ocuparMesa(
    @PathVariable("id") int id,
    @RequestBody MesaEntity mesa
  ) {
    MesaEntity mesaAtual = mesaRepository.findById(id).get();
    mesaAtual.setLivre(false);
    return mesaRepository.save(mesaAtual);
  }

  @DeleteMapping("/{id}")
  public String deletarMesa(@PathVariable("id") int id) {
    mesaRepository.deleteById(id);
    return "Mesa deletada";
  }
}
