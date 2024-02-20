package restaurant.com.restaurante.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "mesa")
public class MesaEntity {

  @Id
  @GeneratedValue
  private int id;

  private int numero;
  private boolean livre = true;
}
