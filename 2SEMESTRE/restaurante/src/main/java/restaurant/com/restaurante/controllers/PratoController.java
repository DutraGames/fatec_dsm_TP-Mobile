package restaurant.com.restaurante.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import restaurant.com.restaurante.entities.PratoEntity;
import restaurant.com.restaurante.repository.PratoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/prato")
public class PratoController {

    @Autowired
    PratoRepository pratoRepository;
    
    @PostMapping()
    public PratoEntity criarPrato(@RequestBody PratoEntity prato) {
        return pratoRepository.save(prato);
    }

    @GetMapping()
    public List<PratoEntity> buscarTodosOsPratos() {
        return pratoRepository.findAll();
    }
    
    
}
