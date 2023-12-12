package mx.veterinaria.chichen.itzamna.itzamna10.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tbl_detalle_venta")
public class DetalleVentaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long idDetalle;

    @Column(name = "fecha_detalle")
    private LocalDate fechaDetalle;

    @Column(name = "cantidad_detalle")
    private Integer cantidadDetalle;

    @Column(name = "precio_detalle")
    private Double precioTotalDetalle;

    @ManyToOne
    @JoinColumn(name = "venta")
    private VentasModel ventas;

    @ManyToOne
    @JoinColumn(name = "producto")
    private ProductosModel productoDetalle;

    @ManyToOne
    @JoinColumn(name = "servicio")
    private ServiciosPacientesModel servicio;

}
