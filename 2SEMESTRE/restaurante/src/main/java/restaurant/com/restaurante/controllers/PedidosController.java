package restaurant.com.restaurante.controllers;

import java.text.DecimalFormat;
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
import restaurant.com.restaurante.entities.PedidoEntity;
import restaurant.com.restaurante.entities.PratoEntity;
import restaurant.com.restaurante.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

  @Autowired
  PedidoRepository pedidoRepository;

  DecimalFormat decimalFormat = new DecimalFormat("0.00");

  @PostMapping
  public PedidoEntity criarPedido(@RequestBody List<PratoEntity> pratos) {
    double valorTotal = 0;

    for (PratoEntity prato : pratos) {
      valorTotal += prato.getPreco();
    }

    PedidoEntity pedido = new PedidoEntity();
    pedido.setPratos(pratos);
    pedido.setValorTotal(valorTotal);
    double valorEntrega = valorTotal * 0.01;
    String valorEntregaFormatado = decimalFormat.format(valorEntrega);
    pedido.setValorEntrega(Double.parseDouble(valorEntregaFormatado));

    return pedidoRepository.save(pedido);
  }

  @GetMapping
  public List<PedidoEntity> buscarTodosOsPedidos() {
    return pedidoRepository.findAll();
  }

  @GetMapping("/{id}")
  public PedidoEntity buscarUmPedido(@PathVariable int id) {
    return pedidoRepository.findById(id).get();
  }

  @DeleteMapping("/{id}")
  public String deletarPedido(@PathVariable int id) {
    pedidoRepository.deleteById(id);
    return "Pedido deletado";
  }

  @PutMapping("/{id}")
  public PedidoEntity atualizarPedido(
    @PathVariable int id,
    @RequestBody PedidoEntity pedido
  ) {
    PedidoEntity pedidoAtual = pedidoRepository.findById(id).get();

    pedidoAtual.setPratos(pedido.getPratos());
    pedidoAtual.setValorTotal(pedido.getValorTotal());
    pedidoAtual.setValorEntrega(pedido.getValorEntrega());

    return pedidoRepository.save(pedidoAtual);
  }
}
