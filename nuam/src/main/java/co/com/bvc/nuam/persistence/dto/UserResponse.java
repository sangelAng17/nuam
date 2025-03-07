package co.com.bvc.nuam.persistence.dto;

import lombok.Data;

@Data
public class UserResponse {

    public Long idUser;
    public Long totalTransaccionVenta;
    public Long totalTransaccionCompra;
    public Double precioTotalCompra;
    public Double precioTotalVenta;

}
