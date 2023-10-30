package mx.veterinaria.chichen.itzamna.itzamna10.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_paciente")
public class PacientesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long idPaciente;

    @Column(name = "tipo_paciente")
    private String tipoMascotaPaciente;

    @Column(name = "nombre_paciente")
    private String nombre_paciente;

    @Column(name = "raza_paciente")
    private String razaPaciente;

    @Column(name = "color_paciente")
    private String colorPaciente;

    @Column(name = "sexo_paciente")
    private String sexoPaciente;

    @Column(name = "edad_paciente")
    private Double edadPaciente;

    @Column(name = "fecha_alta")
    private LocalDate fechaAltaPaciente;

    @ManyToOne
    private PropietarioModel propietario;

    @OneToMany
    private List<ResponsivasModel> responsivas;
}
