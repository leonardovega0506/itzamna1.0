package mx.veterinaria.chichen.itzamna.itzamna10.model.dto;

import lombok.Data;

import javax.persistence.*;

@Data
public class ProductosDTO {

    private long idProducto;
    private String claveProducto;
    private String tipoProducto;
    private String nombreProducto;
    private String marcaProducto;
    private Double costoProducto;
    private Double precioClienteProducto;
    private Integer cantidadProducto;
    private String descripcionProducto;
    private ProveedorDTO proveedor;
}
