package mx.veterinaria.chichen.itzamna.itzamna10.model.dto;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data

public class DiarioDTO {

    private Long idDiario;
    LocalDate fechaDiario;
    private ServiciosPacientesDTO servicioDiario;
    private Double ventaDiaria;
    private ComprasDTO compraDiario;
}
