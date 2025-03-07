package co.com.bvc.nuam.controller;

import co.com.bvc.nuam.persistence.dto.CompanyResponse;
import co.com.bvc.nuam.persistence.dto.UserResponse;
import co.com.bvc.nuam.persistence.entity.Company;
import co.com.bvc.nuam.persistence.entity.Transactions;
import co.com.bvc.nuam.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/transactions")
public class TransactionsController {

    @Autowired
    private TransactionsService transactionsService;

    @GetMapping("/")
    public ResponseEntity<ArrayList<Transactions>> findAll(){
        try{
            return ResponseEntity.ok(transactionsService.findAll());
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Transactions>> findAllById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(transactionsService.findById(id));
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Transactions> findAllById(@RequestBody Transactions Transactions){
        try{
            return ResponseEntity.ok(transactionsService.UpdateById(Transactions));
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        try{
            transactionsService.deteteById(id);
            return ResponseEntity.ok("");
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<Transactions> insert(@RequestBody Transactions transactions){
        try{
            return ResponseEntity.ok(transactionsService.save(transactions));
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getIdUser/{id}")
    public ResponseEntity<List<Transactions>> getUserById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(transactionsService.getTransactionByUser(id));
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getNitCompany/{id}")
    public ResponseEntity<List<Transactions>> getCompanyById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(transactionsService.getTransactionByCompany(id));
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/filterDate")
    public ResponseEntity<List<Transactions>> getCompanyById(@RequestParam String datefirst,
                                                             @RequestParam String datesecond){
        try{
            return ResponseEntity.ok(transactionsService.getTransactionByCompany(datefirst,datesecond));
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/infoResumenUserTrans/{id}")
    public ResponseEntity<UserResponse> getinfoResumenUsderTransaction(@PathVariable Long id){
        try{
            return ResponseEntity.ok(transactionsService.getTransactionByUserResumen(id));
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/infoResumenCompanyTran/{id}")
    public ResponseEntity<CompanyResponse> getinfoResumenCompanyTransaction(@PathVariable Long id){
        try{
            return ResponseEntity.ok(transactionsService.getTransactionByCompanyResumen(id));
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

}
