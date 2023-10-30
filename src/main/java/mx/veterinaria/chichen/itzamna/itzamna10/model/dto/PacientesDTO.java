package mx.veterinaria.chichen.itzamna.itzamna10.model.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class PacientesDTO {

    private Long idPaciente;
    private String tipoMascotaPaciente;
    private String nombre_paciente;
    private String razaPaciente;
    private String colorPaciente;
    private String sexoPaciente;
    private Double edadPaciente;
    private PropietarioDTO propietario;
    private List<ResponsivasDTO> responsivas;
}
