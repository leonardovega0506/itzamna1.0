package mx.veterinaria.chichen.itzamna.itzamna10.model.dto;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
public class ServiciosPacientesDTO {

    private Long idServicioPaciente;
    private ServiciosDTO servicio;
    private PacientesDTO paciente;
    private String seguimientoServicio;
    private String eventoServicio;
    private String totalEvento;
    private LocalDate fechaServicio;
    private LocalDate fechaPosteriorServicio;
}
