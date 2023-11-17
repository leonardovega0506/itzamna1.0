package mx.veterinaria.chichen.itzamna.itzamna10.model.dto;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
public class PropietarioDTO {

    private Long idPropietario;
    private String nombrePropietario;
    private String domicilioPropietario;
    private String telefono1Propietario;
    private String telefono2Propietario;
    private String observacionesPropietario;
    private String emailPropietario;
    private String fechaAltaPropietario;
    private List<PacientesDTO> pacientes;
    private List<ResponsivasDTO> responsivas;
}
