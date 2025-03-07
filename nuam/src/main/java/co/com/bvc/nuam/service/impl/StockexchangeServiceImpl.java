package co.com.bvc.nuam.service.impl;

import co.com.bvc.nuam.persistence.entity.Company;
import co.com.bvc.nuam.persistence.entity.Stockexchange;
import co.com.bvc.nuam.persistence.repository.CompanyRepository;
import co.com.bvc.nuam.persistence.repository.StockexchangeRepository;
import co.com.bvc.nuam.service.StockexchangeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StockexchangeServiceImpl implements StockexchangeService {

    private static Logger log = LogManager.getLogger(StockexchangeServiceImpl.class);

    @Autowired
    private StockexchangeRepository stockexchangeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    private Stockexchange response;

    @Override
    public ArrayList<Stockexchange> findAll(){
        return (ArrayList<Stockexchange>) stockexchangeRepository.findAll();
    }
    @Override
    public Optional<Stockexchange> findById(Long id){
        return stockexchangeRepository.findById(id);
    }

    @Override
    public Stockexchange UpdateById(Stockexchange stockexchange) throws Exception{
        try{
            stockexchangeRepository.save(stockexchange);
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
        return stockexchangeRepository.findAllById(stockexchange.getId());
    }

    @Override
    public void deteteById(Long id)  throws Exception{
        try{
            stockexchangeRepository.deleteById(id);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    public Stockexchange save(Stockexchange stockexchange)  throws Exception{
        try{
            response = stockexchangeRepository.save(stockexchange);
            Company company = companyRepository.findAllById(stockexchange.company.getId());
            response.setCompany(company);

        }catch (Exception e){
            log.error(e.getMessage());
        }
        return response;
    }

}
