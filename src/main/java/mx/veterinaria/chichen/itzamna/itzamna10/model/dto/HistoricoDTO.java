package mx.veterinaria.chichen.itzamna.itzamna10.model.dto;

import lombok.Data;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.*;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
public class HistoricoDTO {

    private Long idHistorico;
    LocalDate fechaHistorico;
    private Double valorHistroico;
    private ComprasDTO compraHistorico;
    private VentasDTO ventaHistorica;
    private SumaHistoricoModel sumaHistorico;
}
