package mx.veterinaria.chichen.itzamna.itzamna10.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_detalle_compra")
public class DetalleCompraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long idDetalle;

    @ManyToOne
    private ProductosModel productoDetalle;

    @ManyToOne
    private ProveedorModel proveedorDetalle;

    @Column(name = "cantidad_detalle")
    private Integer cantidadDetalle;

    @Column(name = "precio_detalle")
    private Double precioTotalDetalle;
}
