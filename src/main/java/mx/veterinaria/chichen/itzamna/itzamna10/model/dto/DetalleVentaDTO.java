package mx.veterinaria.chichen.itzamna.itzamna10.model.dto;

import lombok.Data;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ProductosModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ProveedorModel;

import javax.persistence.*;
import java.time.LocalDate;

@Data
public class DetalleVentaDTO {


    private Long idDetalle;
    private LocalDate fechaDetalle;
    private ProductosModel productoDetalle;
    private ProveedorModel proveedorDetalle;
    private Integer cantidadDetalle;
    private Double precioTotalDetalle;
}
