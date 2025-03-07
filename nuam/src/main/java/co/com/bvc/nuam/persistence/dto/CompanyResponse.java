package co.com.bvc.nuam.persistence.dto;

import lombok.Data;

@Data
public class CompanyResponse {
    public Long idCompany;

    public String name;
    public Long totalTransaccionVenta;
    public Long totalTransaccionCompra;
    public Double precioTotalCompra;
    public Double precioTotalVenta;

}
