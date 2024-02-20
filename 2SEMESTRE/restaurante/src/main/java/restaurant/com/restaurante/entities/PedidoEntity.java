package restaurant.com.restaurante.entities;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
    @ManyToMany(cascade = CascadeType.ALL)
    private ArrayList<PratoEntity> pratos = new ArrayList<>();
    private double valorTotal;

    public void adicionarPrato(PratoEntity prato){
        
        this.pratos.add(prato);
        this.valorTotal += prato.getPreco();
    }
}
