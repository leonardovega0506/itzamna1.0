package mx.veterinaria.chichen.itzamna.itzamna10.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tbl_diario")
public class DiarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_diario")
    private Long idDiario;

    @Column(name = "fecha_diario",nullable = false)
    LocalDate fechaDiario;

    @ManyToOne
    private ProductosModel productoDiario;

    @ManyToOne
    private ServiciosPacientesModel servicioDiario;

    @Column(name = "venta_diaria")
    private Double ventaDiaria;

    @Column(name = "acumulado_diario")
    private Double AcumuladoDiario;

    @ManyToOne
    private ComprasModel compraDiario;
}
