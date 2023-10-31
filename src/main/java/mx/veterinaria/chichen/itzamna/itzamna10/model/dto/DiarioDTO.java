package mx.veterinaria.chichen.itzamna.itzamna10.model.dto;

import lombok.Data;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.VentasModel;

import javax.persistence.*;
import java.time.LocalDate;

@Data

public class DiarioDTO {

    private Long idDiario;
    LocalDate fechaDiario;
    private VentasDTO ventas;
    private Double valorDiario;
    private ComprasDTO compra;
}
