package co.com.bvc.nuam.service.impl;

import co.com.bvc.nuam.persistence.entity.Company;
import co.com.bvc.nuam.persistence.repository.CompanyRepository;
import co.com.bvc.nuam.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    private static Logger log = LogManager.getLogger(CompanyServiceImpl.class);


    @Override
    public ArrayList<Company> findAll(){
        return (ArrayList<Company>) companyRepository.findAll();
    }
    @Override
    public Optional<Company> findById(Long id){
        return companyRepository.findById(id);
    }

    @Override
    public Company UpdateById(Company company) throws Exception{
        try{
            companyRepository.save(company);
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
        return companyRepository.findAllById(company.getId());
    }

    @Override
    public void deteteById(Long id) throws Exception{
        try{
            companyRepository.deleteById(id);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    public Company save(Company company) throws Exception {
        try{
            companyRepository.save(company);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return company;
    }

}
