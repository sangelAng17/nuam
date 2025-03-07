package co.com.bvc.nuam.service;

import co.com.bvc.nuam.persistence.entity.Company;

import java.util.ArrayList;
import java.util.Optional;

public interface CompanyService {
    ArrayList<Company> findAll();

    Optional<Company> findById(Long id);

    Company UpdateById(Company company) throws Exception;

    void deteteById(Long id) throws Exception;

    Company save(Company company) throws Exception;
}
