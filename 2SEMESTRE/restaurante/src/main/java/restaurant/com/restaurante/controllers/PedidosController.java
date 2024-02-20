package restaurant.com.restaurante.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restaurant.com.restaurante.entities.PedidoEntity;
import restaurant.com.restaurante.repository.PedidoRepository;
import restaurant.com.restaurante.repository.PratoRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    PratoRepository pratoRepository;
    @PostMapping()
public PedidoEntity criarPedido(@RequestBody PedidoEntity pedido) {
    return pedidoRepository.save(pedido);
}
    

    @GetMapping()
    public List<PedidoEntity> buscarTodosOsPedidos() {
        return pedidoRepository.findAll();        
    }
    
}
