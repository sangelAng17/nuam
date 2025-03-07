package co.com.bvc.nuam.controller;

import co.com.bvc.nuam.persistence.entity.Company;
import co.com.bvc.nuam.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/")
    public ResponseEntity<ArrayList<Company>> findAll(){
        try{
            return ResponseEntity.ok(companyService.findAll());
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Company>> findAllById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(companyService.findById(id));
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Company> findAllById(@RequestBody Company ciudad){
        try{
            return ResponseEntity.ok(companyService.UpdateById(ciudad));
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        try{
            companyService.deteteById(id);
            return ResponseEntity.ok("");
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<Company> insert(@RequestBody Company company){
        try{
            return ResponseEntity.ok(companyService.save(company));
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

}
