package restaurant.com.restaurante.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurant.com.restaurante.entities.MesaEntity;
import restaurant.com.restaurante.repository.MesaRepository;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    MesaRepository mesaRepository;

    @GetMapping()
    public List<MesaEntity> buscarTodasAsMesas() {
        return mesaRepository.findAll();   
    }
    
}
