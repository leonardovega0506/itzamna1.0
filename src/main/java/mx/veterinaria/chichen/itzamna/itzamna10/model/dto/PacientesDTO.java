package mx.veterinaria.chichen.itzamna.itzamna10.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class PacientesDTO {

    private Long idPaciente;
    private String tipoMascotaPaciente;
    private String nombrePaciente;
    private String razaPaciente;
    private String colorPaciente;
    private String sexoPaciente;
    private String edadPaciente;
    @JsonIgnoreProperties({"pacientes"})
    private PropietarioDTO propietario;
    private List<ResponsivasDTO> responsivas;
}
