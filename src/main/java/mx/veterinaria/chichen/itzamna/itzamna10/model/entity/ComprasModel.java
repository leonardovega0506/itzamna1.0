package mx.veterinaria.chichen.itzamna.itzamna10.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_compra")
public class ComprasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Long idCompra;

    @OneToMany
    @Column(name = "producto")
    private List<DetalleCompraModel> productosCompra;

    @Column(name = "total_compra")
    private Double totalCompra;

    @Column(name = "fecha_compra")
    private LocalDate fechaCompra;

    @Column(name = "factura_compra")
    private String facturaCompra;

    @Column(name = "nota_compra")
    private String notaCompra;

    @ManyToOne
    private ProveedorModel proveedor;
}
