package mx.veterinaria.chichen.itzamna.itzamna10.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ServiciosDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tbl_cita")
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "servicio")
    @JsonIgnore
    private ServiciosModel servicio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente")
    @JsonIgnore
    private PacientesModel paciente;
}
