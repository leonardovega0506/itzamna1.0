package mx.veterinaria.chichen.itzamna.itzamna10.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_productos")
public class ProductosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private long idProducto;

    @Column(name = "clave_producto",unique = true)
    private String claveProducto;

    @Column(name = "tipo_producto")
    private String tipoProducto;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "costo_producto")
    private Double costoProducto;

    @Column(name = "cantidad_producto")
    private Integer cantidadProducto;

    @Column(name = "precio_producto")
    private Double precioProducto;

    @ManyToOne
    private ProveedorModel proveedor;
}
