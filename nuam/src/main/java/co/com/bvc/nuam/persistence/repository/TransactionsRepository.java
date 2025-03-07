package co.com.bvc.nuam.persistence.repository;

import co.com.bvc.nuam.persistence.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transactions,Long> {
    Transactions findAllById(Long id);

    @Query(value = "select SUM(t.amount) from nuam.transactions t where t.id_stockexchange = ?1", nativeQuery = true)
    Long amountTrans(Long id);

    @Query(value = "select * from nuam.transactions t where t.id_user  = ?1", nativeQuery = true)
    List<Transactions> findAllByUserN(Long id);

    @Query(value = "select t.*  from nuam.transactions t " +
            "inner join nuam.stockexchange s on s.id = t.id_stockexchange " +
            "inner join nuam.company c on c.id = s.idcompany " +
            "where c.id = ?1", nativeQuery = true)
    List<Transactions> findAllByCompany(Long id);

    @Query(value = "select * from nuam.transactions t where t.date_transaction  between ?1 and ?2 ", nativeQuery = true)
    List<Transactions> findAllByDateTransactionBetween(Date datefirst,Date datesecond);



}
