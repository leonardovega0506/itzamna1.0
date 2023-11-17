package mx.veterinaria.chichen.itzamna.itzamna10.model.dto;

import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.PacientesModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ServiciosModel;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class CitasDTO {

    private Long idCita;
    private LocalDate fechaCita;
    private LocalTime horaCita;
    private ServiciosModel servicio;
    private PacientesModel paciente;
}
