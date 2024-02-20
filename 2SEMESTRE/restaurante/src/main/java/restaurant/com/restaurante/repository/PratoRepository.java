package restaurant.com.restaurante.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.com.restaurante.entities.PratoEntity;
public interface PratoRepository extends JpaRepository<PratoEntity, Integer> {    }
