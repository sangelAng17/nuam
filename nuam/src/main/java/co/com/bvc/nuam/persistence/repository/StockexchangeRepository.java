package co.com.bvc.nuam.persistence.repository;

import co.com.bvc.nuam.persistence.entity.Stockexchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockexchangeRepository extends JpaRepository<Stockexchange,Long> {
    Stockexchange findAllById(Long id);
}
