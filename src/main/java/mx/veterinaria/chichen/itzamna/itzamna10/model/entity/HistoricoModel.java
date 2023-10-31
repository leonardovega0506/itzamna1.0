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


    @Column(name = "valor_historico")
    private Double valorHistroico;

    @ManyToOne
    private ComprasModel compraHistorico;

    @ManyToOne
    private VentasModel ventaHistorica;

    @ManyToOne
    private SumaHistoricoModel sumaHistorico;
}
