package mx.veterinaria.chichen.itzamna.itzamna10.model.entity;

import lombok.Data;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ServiciosDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "cita")
@Data
public class CitasModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long idCita;

    @Column(name = "fecha_cita")
    private LocalDate fechaCita;

    @Column(name = "hora_cita")
    private LocalTime horaCita;

    @ManyToOne
    private ServiciosModel servicio;

    @ManyToOne
    private PacientesModel paciente;
}
