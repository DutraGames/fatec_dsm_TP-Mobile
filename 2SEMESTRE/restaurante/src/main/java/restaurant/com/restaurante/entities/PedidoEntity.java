package restaurant.com.restaurante.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "pedido")
public class PedidoEntity {

  @Id
  @GeneratedValue
  private int id;

  @ManyToMany
  @JoinTable(
    name = "pedido_prato",
    joinColumns = @JoinColumn(name = "pedido_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(
      name = "prato_id",
      referencedColumnName = "id"
    )
  )
  private List<PratoEntity> pratos = new ArrayList<>();

  private double valorTotal;
  private double valorEntrega;
}
