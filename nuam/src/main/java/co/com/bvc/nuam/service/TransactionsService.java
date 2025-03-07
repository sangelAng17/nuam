package co.com.bvc.nuam.service;

import co.com.bvc.nuam.persistence.dto.CompanyResponse;
import co.com.bvc.nuam.persistence.dto.UserResponse;
import co.com.bvc.nuam.persistence.entity.Transactions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface TransactionsService {
    ArrayList<Transactions> findAll();

    Optional<Transactions> findById(Long id);

    Transactions UpdateById(Transactions transactions);

    void deteteById(Long id);

    Transactions save(Transactions transactions);

    List<Transactions> getTransactionByUser(Long id) throws Exception;

    List<Transactions> getTransactionByCompany(Long id) throws Exception;

    List<Transactions> getTransactionByCompany(String datefirst,
                                               String datesecond) throws Exception;

    UserResponse getTransactionByUserResumen(Long id) throws Exception;

    CompanyResponse getTransactionByCompanyResumen(Long id) throws Exception;
}
