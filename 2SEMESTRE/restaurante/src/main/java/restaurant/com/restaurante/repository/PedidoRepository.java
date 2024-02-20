package restaurant.com.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import restaurant.com.restaurante.entities.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer> {

    
}
