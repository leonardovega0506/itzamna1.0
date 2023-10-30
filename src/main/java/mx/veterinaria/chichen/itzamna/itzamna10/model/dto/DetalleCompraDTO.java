package mx.veterinaria.chichen.itzamna.itzamna10.model.dto;

import lombok.Data;

import javax.persistence.*;

@Data
public class DetalleCompraDTO {

    private Long idDetalle;
    private ProductosDTO productoDetalle;
    private ProveedorDTO proveedorDetalle;
    private Integer cantidadDetalle;
    private Double precioTotalDetalle;
}
