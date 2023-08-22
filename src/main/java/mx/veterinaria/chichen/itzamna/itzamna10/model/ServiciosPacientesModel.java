package mx.veterinaria.chichen.itzamna.itzamna10.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tbl_Servicio_paciente")
public class ServiciosPacientesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio_paciente")
    private Long idServicioPaciente;

    @ManyToOne
    private ServiciosModel servicio;

    @ManyToOne
    private PacientesModel paciente;

    @Column(name = "seguimiento_servicio")
    private String seguimientoServicio;

    @Column(name = "evento_servicio")
    private String eventoServicio;

    @Column(name = "total_evento_servicio")
    private String totalEvento;

    @Column(name = "fecha_servicio")
    private LocalDate fechaServicio;

    @Column(name = "fecha_posterior_Servicio")
    private LocalDate fechaPosteriorServicio;
}
