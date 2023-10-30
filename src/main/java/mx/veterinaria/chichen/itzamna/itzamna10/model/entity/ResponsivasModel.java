package mx.veterinaria.chichen.itzamna.itzamna10.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tbl_resposiva")
public class ResponsivasModel {

    @Id
    @Column(name = "id_responsiva")
    private Long idResposiva;

    @Column(name = "fecha_Responsiva")
    private LocalDate fechaResponsiva;

    @ManyToOne
    private ServiciosModel servicio;

    @ManyToOne
    private PacientesModel paciente;

    @ManyToOne
    private PropietarioModel propietario;

    @Column(name = "conformidad")
    private Boolean conformeResponsiva;
}
