package mx.veterinaria.chichen.itzamna.itzamna10.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "historico")
@Data
public class HistoricoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historico")
    private Long idHistorico;

    @Column(name = "fecha_historico",nullable = false)
    LocalDate fechaHistorico;

    @ManyToOne
    private ProductosModel productoHistorico;

    @ManyToOne
    private ServiciosPacientesModel servicioHistorico;

    @Column(name = "venta_historica")
    private Double ventaHistorico;

    @ManyToOne
    private ComprasModel compraHistorico;
}
