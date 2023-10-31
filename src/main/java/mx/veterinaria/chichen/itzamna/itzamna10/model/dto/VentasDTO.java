package mx.veterinaria.chichen.itzamna.itzamna10.model.dto;

import lombok.Data;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ProductosModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ServiciosPacientesModel;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
public class VentasDTO {

    private Long idVenta;
    private Double totalVenta;
    private LocalDate fechaVenta;
    private ServiciosPacientesModel servicioP;
    private ProductosModel producto;
}
