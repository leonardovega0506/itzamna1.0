package mx.veterinaria.chichen.itzamna.itzamna10.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_ventas")
public class VentasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long idVenta;

    @Column(name = "total_compra")
    private Double totalVenta;

    @Column(name = "fecha_compra")
    private LocalDate fechaVenta;

    @ManyToOne
    @JoinColumn(name = "servicio")
    private ServiciosModel servicio;

    @ManyToOne
    @JoinColumn(name = "producto")
    private ProductosModel producto;

}
