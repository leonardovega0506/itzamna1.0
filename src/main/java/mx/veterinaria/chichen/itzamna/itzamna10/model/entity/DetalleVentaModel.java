package mx.veterinaria.chichen.itzamna.itzamna10.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "detalle_venta")
public class DetalleVentaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long idDetalle;

    @Column(name = "fecha_detalle")
    private LocalDate fechaDetalle;

    @ManyToOne
    private ProductosModel productoDetalle;

    @ManyToOne
    private ServiciosPacientesModel servicio;

    @Column(name = "cantidad_detalle")
    private Integer cantidadDetalle;

    @Column(name = "precio_detalle")
    private Double precioTotalDetalle;

    @ManyToOne
    private VentasModel ventas;

}
