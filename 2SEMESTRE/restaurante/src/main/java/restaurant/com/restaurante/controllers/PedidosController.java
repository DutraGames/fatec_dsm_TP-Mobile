package restaurant.com.restaurante.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restaurant.com.restaurante.entities.PedidoEntity;
import restaurant.com.restaurante.entities.PratoEntity;
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
public ResponseEntity<?> criarPedido(@RequestBody PedidoEntity pedido) {
    // Verificar se todos os pratos do pedido existem no banco de dados
    for (PratoEntity prato : pedido.getPratos()) {
        Optional<PratoEntity> pratoOptional = pratoRepository.findById(prato.getId());
        if (!pratoOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Prato com ID " + prato.getId() + " não encontrado.");
        }
    }

    // Se todos os pratos existirem, calcular o valor total do pedido e salvá-lo
    double valorTotal = 0.0;
    for (PratoEntity prato : pedido.getPratos()) {
        valorTotal += prato.getPreco();
    }
    pedido.setValorTotal(valorTotal);
    
    PedidoEntity pedidoSalvo = pedidoRepository.save(pedido);
    return ResponseEntity.ok(pedidoSalvo);
}
    

    @GetMapping()
    public List<PedidoEntity> buscarTodosOsPedidos() {
        return pedidoRepository.findAll();        
    }
    
}
