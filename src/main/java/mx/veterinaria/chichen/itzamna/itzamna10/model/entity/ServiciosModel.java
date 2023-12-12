package mx.veterinaria.chichen.itzamna.itzamna10.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_servicio")
public class ServiciosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Long idServicio;

    @Column(name = "clave_servicio",unique = true)
    private String claveServicio;

    @Column(name = "tipo_servicio")
    private String tipoServicio;

    @Column(name = "nombre_servicio")
    private String nombreServicio;

    @Column(name = "costo_servicio")
    private Double costoServicio;

    @Column(name = "duracion")
    private String duracion;

    @Column(name = "descripcion_servicio")
    private String descripcionServicio;

    @OneToMany(mappedBy = "servicio")
    private List<ServiciosPacientesModel> serviciosPacientes;

    @OneToMany(mappedBy = "servicio")
    private List<ResponsivasModel> responsivas;

    @OneToMany(mappedBy = "servicio")
    private List<CitasModel> citas;
}
