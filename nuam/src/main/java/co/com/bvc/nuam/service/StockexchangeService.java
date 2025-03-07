package co.com.bvc.nuam.service;

import co.com.bvc.nuam.persistence.entity.Stockexchange;

import java.util.ArrayList;
import java.util.Optional;

public interface StockexchangeService {
    ArrayList<Stockexchange> findAll();

    Optional<Stockexchange> findById(Long id);

    Stockexchange UpdateById(Stockexchange stockexchange) throws Exception;

    void deteteById(Long id) throws Exception;

    Stockexchange save(Stockexchange stockexchange) throws Exception;
}
