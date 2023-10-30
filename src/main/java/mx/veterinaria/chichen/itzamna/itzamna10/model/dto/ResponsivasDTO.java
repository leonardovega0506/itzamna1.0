package mx.veterinaria.chichen.itzamna.itzamna10.model.dto;

import lombok.Data;

import javax.persistence.*;

@Data
public class ResponsivasDTO {

    private Long idResposiva;
    private ServiciosDTO servicio;
    private PacientesDTO paciente;
    private PropietarioDTO propietario;
    private Boolean conformeResponsiva;
}
