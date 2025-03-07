package co.com.bvc.nuam.persistence.repository;

import co.com.bvc.nuam.persistence.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
    Company findAllById(Long id);
}
