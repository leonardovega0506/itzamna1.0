package mx.veterinaria.chichen.itzamna.itzamna10.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_propietario")
public class PropietarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_propietario")
    private Long idPropietario;

    @Column(name = "nombre_propietario", nullable = false)
    private String nombrePropietario;

    @Column(name = "domiclio_propietario")
    private String domicilioPropietario;

    @Column(name = "telefono1_propietario", nullable = false)
    private String telefono1Propietario;

    @Column(name = "telefono2_propietario")
    private String telefono2Propietario;

    @Column(name = "observaciones_propietario")
    private String observacionesPropietario;

    @Column(name = "email_propietario")
    private String emailPropietario;

    @Column(name = "fecha_alta")
    private String fechaAltaPropietario;

    @OneToMany
    private List<PacientesModel> pacientes;

    @OneToMany
    private List<ResponsivasModel> responsivas;
}
