package mx.veterinaria.chichen.itzamna.itzamna10.model.dto;

import lombok.Data;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ComprasModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ProductosModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ServiciosPacientesModel;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
public class HistoricoDTO {

    private Long idHistorico;
    LocalDate fechaHistorico;
    private ProductosModel productoHistorico;
    private ServiciosPacientesModel servicioHistorico;
    private Double ventaHistorico;
    private ComprasModel compraHistorico;
}
