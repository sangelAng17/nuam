package co.com.bvc.nuam.controller;


import co.com.bvc.nuam.persistence.entity.Stockexchange;
import co.com.bvc.nuam.service.StockexchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/stockexchange")
public class StockexchangeController {

    @Autowired
    private StockexchangeService stockexchangeService;

    @GetMapping("/")
    public ResponseEntity<ArrayList<Stockexchange>> findAll(){
        try{
            return ResponseEntity.ok(stockexchangeService.findAll());
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Stockexchange>> findAllById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(stockexchangeService.findById(id));
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Stockexchange> findAllById(@RequestBody Stockexchange stockexchange){
        try{
            return ResponseEntity.ok(stockexchangeService.UpdateById(stockexchange));
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        try{
            stockexchangeService.deteteById(id);
            return ResponseEntity.ok("");
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<Stockexchange> insert(@RequestBody Stockexchange stockexchange){
        try{
            return ResponseEntity.ok(stockexchangeService.save(stockexchange));
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }


}
