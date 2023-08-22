package mx.veterinaria.chichen.itzamna.itzamna10.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_resposiva")
public class ResponsivasModel {

    @Id
    @Column(name = "id_responsiva")
    private Long idResposiva;

    @ManyToOne
    private ServiciosModel servicio;

    @ManyToOne
    private PacientesModel paciente;

    @ManyToOne
    private PropietarioModel propietario;

    @Column(name = "conformidad")
    private Boolean conformeResponsiva;
}
