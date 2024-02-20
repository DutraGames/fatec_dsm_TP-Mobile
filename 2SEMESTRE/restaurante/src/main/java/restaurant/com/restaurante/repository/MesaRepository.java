package restaurant.com.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import restaurant.com.restaurante.entities.MesaEntity;

public interface MesaRepository extends JpaRepository<MesaEntity, Integer> {
    
}
