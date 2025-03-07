package co.com.bvc.nuam.service.impl;

import co.com.bvc.nuam.persistence.dto.CompanyResponse;
import co.com.bvc.nuam.persistence.dto.UserResponse;
import co.com.bvc.nuam.persistence.entity.Stockexchange;
import co.com.bvc.nuam.persistence.entity.Transactions;
import co.com.bvc.nuam.persistence.entity.User;
import co.com.bvc.nuam.persistence.repository.StockexchangeRepository;
import co.com.bvc.nuam.persistence.repository.TransactionsRepository;
import co.com.bvc.nuam.persistence.repository.UserRepository;
import co.com.bvc.nuam.service.StockexchangeService;
import co.com.bvc.nuam.service.TransactionsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionsServiceImpl implements TransactionsService {

    private List<Transactions> responseList = new ArrayList<>();
    private Transactions Response;
    private final UserResponse responseDetailsUserResumen = new UserResponse();
    private final CompanyResponse responseDetailsCompanyResumen = new CompanyResponse();


    private static Logger log = LogManager.getLogger(StockexchangeServiceImpl.class);
    private Long totalVentas;
    private Double totalVentasPrice;
    private Long totalCompras;
    private Double totalComprasPrice;

    @Autowired
    private TransactionsRepository transactionsRepository;
    @Autowired
    private StockexchangeRepository stockexchangeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StockexchangeService stockexchangeService;


    @Override
    public ArrayList<Transactions> findAll(){
        return (ArrayList<Transactions>) transactionsRepository.findAll();
    }
    @Override
    public Optional<Transactions> findById(Long id){
        return transactionsRepository.findById(id);
    }

    @Override
    public Transactions UpdateById(Transactions transactions){
        try{
            transactionsRepository.save(transactions);
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
        return transactionsRepository.findAllById(transactions.getId());
    }

    @Override
    public void deteteById(Long id){
        try{
            transactionsRepository.deleteById(id);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    public Transactions save(Transactions transactions) {
        try{
            switch (transactions.typeTransaction){
                case "compra" : return this.saveCompra(transactions);

                case "venta" : return this.saveVenta(transactions);
            }

        }catch (Exception e){
            log.error(e.getMessage());
        }
        return Response;
    }

    public Boolean validationAmount(Long cantidad,Long total,Long sum){
        cantidad = cantidad != null ? cantidad : 0;
        try{
            if(this.amountTotal(cantidad,sum)<total){
                return Boolean.FALSE;
            }
            else{
                return Boolean.TRUE;
            }
        }catch (Exception e){
            log.error(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Long amountTotal(Long cantidad,Long sum){
        cantidad = cantidad != null ? cantidad : 0;
        try{
            return cantidad+sum;
        }catch (Exception e){
            log.error(e.getMessage());
            return 0L;
        }
    }

    public Transactions saveCompra(Transactions transactions) throws Exception{
        try{
            Stockexchange stockexchange = stockexchangeRepository.findAllById(transactions.getStockexchange().getId());

            if(validationAmount(
                    transactionsRepository.amountTrans(transactions.getStockexchange().getId()),
                    stockexchange.getStock(),
                    transactions.getAmount()
            )){
                throw new Exception("compra invalida");
            }else{
                Response = transactionsRepository.save(transactions);
                User user = userRepository.findAllById(transactions.getUserN().getId());
                Response.setUserN(user);
                Response.setStockexchange(stockexchange);

                stockexchange.setAvailable(
                        this.amountResta(transactionsRepository.amountTrans(
                                        transactions.getStockexchange().getId()),
                                stockexchange.getStock()
                        ));

                stockexchangeService.UpdateById(stockexchange);
            }
            return Response;
        }catch (Exception e){
            log.error(e.getMessage());
            return Response;
        }
    }

    public Transactions saveVenta(Transactions transactions) throws Exception{
        try{
            Stockexchange stockexchange = stockexchangeRepository.findAllById(transactions.getStockexchange().getId());


                Response = transactionsRepository.save(transactions);

                User user = userRepository.findAllById(transactions.getUserN().getId());
                Response.setUserN(user);
                Response.setStockexchange(stockexchange);

                stockexchange.setAvailable(
                        this.amountSuma(transactions.amount,
                                stockexchange.getAvailable())
                );

                stockexchangeService.UpdateById(stockexchange);

            return Response;
        }catch (Exception e){
            log.error(e.getMessage());
            return Response;
        }
    }

    public Long amountResta(Long sum,Long cantidad) throws Exception{
        cantidad = cantidad != null ? cantidad : 0;
        try{
            return cantidad-sum;
        }catch (Exception e){
            log.error(e.getMessage());
            return 0L;
        }
    }

    public Long amountSuma(Long sum,Long cantidad) throws Exception{
        cantidad = cantidad != null ? cantidad : 0;
        try{
            return cantidad+sum;
        }catch (Exception e){
            log.error(e.getMessage());
            return 0L;
        }
    }

    @Override
    public List<Transactions> getTransactionByUser(Long id) throws Exception{
        try{
            return transactionsRepository.findAllByUserN(id);
        }catch (Exception e){
            log.error(e.getMessage());
            return responseList;
        }
    }

    @Override
    public List<Transactions> getTransactionByCompany(Long id) throws Exception{
        try{
            return transactionsRepository.findAllByCompany(id);
        }catch (Exception e){
            log.error(e.getMessage());
            return responseList;
        }
    }

    @Override
    public List<Transactions> getTransactionByCompany(String datefirst,
                                                      String datesecond) throws Exception{
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date datefirstD = sdf.parse(datefirst);
            Date datesecondD = sdf.parse(datesecond);

            return transactionsRepository.findAllByDateTransactionBetween (datefirstD,datesecondD);
        }catch (Exception e){
            log.error(e.getMessage());
            return responseList;
        }
    }

    @Override
    public UserResponse getTransactionByUserResumen(Long id) throws Exception{
        try{
            List<Transactions> details = transactionsRepository.findAllByUserN(id);

            for(Transactions transactions: details){
                switch (transactions.typeTransaction){
                    case "compra" :  totalCompras = responseDetailsUserResumen.getTotalTransaccionCompra() != null ? responseDetailsUserResumen.getTotalTransaccionCompra() : 0;
                                     responseDetailsUserResumen.setTotalTransaccionCompra(totalCompras+transactions.getAmount());


                                    totalComprasPrice = responseDetailsUserResumen.getPrecioTotalCompra() != null ?
                                            responseDetailsUserResumen.getPrecioTotalCompra() : 0;

                                     responseDetailsUserResumen.setPrecioTotalCompra(totalComprasPrice                                             +
                                         Double.parseDouble(transactions.getStockexchange().getPrices()));
                                     break;

                    case "venta" : totalVentas = responseDetailsUserResumen.getTotalTransaccionVenta() != null ? responseDetailsUserResumen.getTotalTransaccionVenta() : 0;
                                    responseDetailsUserResumen.setTotalTransaccionVenta(totalCompras+transactions.getAmount());

                                    totalVentasPrice = responseDetailsUserResumen.getPrecioTotalVenta() != null ?
                                            responseDetailsUserResumen.getPrecioTotalVenta() : 0;

                                    responseDetailsUserResumen.setPrecioTotalVenta(totalVentasPrice                                             +
                                            Double.parseDouble(transactions.getStockexchange().getPrices()));
                                    break;
                }

            }

            responseDetailsUserResumen.setIdUser(id);

            return responseDetailsUserResumen;
        }catch (Exception e){
            log.error(e.getMessage());
            return responseDetailsUserResumen;
        }
    }

    @Override
    public CompanyResponse getTransactionByCompanyResumen(Long id) throws Exception{
        try{
            List<Transactions> details = transactionsRepository.findAllByCompany(id);

            for(Transactions transactions: details){
                switch (transactions.typeTransaction){
                    case "compra" :  totalCompras = responseDetailsCompanyResumen.getTotalTransaccionCompra() != null ? responseDetailsCompanyResumen.getTotalTransaccionCompra() : 0;
                        responseDetailsCompanyResumen.setTotalTransaccionCompra(totalCompras+transactions.getAmount());

                        totalComprasPrice = responseDetailsCompanyResumen.getPrecioTotalCompra() != null ?
                                responseDetailsCompanyResumen.getPrecioTotalCompra() : 0;

                        responseDetailsCompanyResumen.setPrecioTotalCompra(totalComprasPrice                                             +
                                Double.parseDouble(transactions.getStockexchange().getPrices()));
                        break;

                    case "venta" : totalVentas = responseDetailsCompanyResumen.getTotalTransaccionVenta() != null ? responseDetailsCompanyResumen.getTotalTransaccionVenta() : 0;
                        responseDetailsCompanyResumen.setTotalTransaccionVenta(totalCompras+transactions.getAmount());

                        totalVentasPrice = responseDetailsCompanyResumen.getPrecioTotalVenta() != null ?
                                responseDetailsCompanyResumen.getPrecioTotalVenta() : 0;

                        responseDetailsCompanyResumen.setPrecioTotalVenta(totalVentasPrice                                             +
                                Double.parseDouble(transactions.getStockexchange().getPrices()));
                        break;
                }

            }


            responseDetailsCompanyResumen.setIdCompany(id);
            responseDetailsCompanyResumen.setName(details.get(0).getStockexchange().getCompany().getName());

            return responseDetailsCompanyResumen;
        }catch (Exception e){
            log.error(e.getMessage());
            return responseDetailsCompanyResumen;
        }
    }



}
