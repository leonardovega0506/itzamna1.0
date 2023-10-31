package mx.veterinaria.chichen.itzamna.itzamna10.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "totales_historicos")
public class SumaHistoricoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_total")
    private Long idTotal;

    @Column(name = "fecha_total")
    private LocalDate fechaTotal;

    @Column(name = "total")
    private Double sumaTotal;

    List<HistoricoModel> listaHistorico;

}
