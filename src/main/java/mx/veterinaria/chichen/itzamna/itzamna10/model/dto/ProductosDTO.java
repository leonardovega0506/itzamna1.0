package mx.veterinaria.chichen.itzamna.itzamna10.model.dto;

import lombok.Data;

import javax.persistence.*;

@Data
public class ProductosDTO {

    private long idProducto;
    private String claveProducto;
    private String tipoProducto;
    private String nombreProducto;
    private Double costoProducto;
    private Integer cantidadProducto;
    private Double precioProducto;
    private ProveedorDTO proveedor;
}
