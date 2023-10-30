package mx.veterinaria.chichen.itzamna.itzamna10.model.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class ServiciosDTO {

    private Long idServicio;
    private String claveServicio;
    private String tipoServicio;
    private String nombreServicio;
    private Double costoServicio;
    private List<ServiciosDTO> serviciosPacientes;
    private List<ResponsivasDTO> responsivas;

}
