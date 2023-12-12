package mx.veterinaria.chichen.itzamna.itzamna10.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tbl_detalle_compra")
public class DetalleCompraModel {

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
    @JoinColumn(name = "compra")
    @JsonIgnore
    private ComprasModel compra;

    @ManyToOne
    @JoinColumn(name = "producto")
    @JsonIgnore
    private ProductosModel productoDetalle;

    @ManyToOne
    @JoinColumn(name = "proveedor")
    private ProveedorModel proveedorDetalle;
}
