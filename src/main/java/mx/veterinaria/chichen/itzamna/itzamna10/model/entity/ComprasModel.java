package mx.veterinaria.chichen.itzamna.itzamna10.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @Column(name = "total_compra")
    private Double totalCompra;

    @Column(name = "estatus_compra")
    private String estatusCompra;

    @Column(name = "fecha_compra")
    private LocalDate fechaCompra;

    @Column(name = "factura")
    private String factura;

    @Column(name = "factura_compra")
    private Boolean facturaCompra;

    @Column(name = "nota_compra")
    private String notaCompra;

    @OneToMany(mappedBy = "compra",cascade = CascadeType.REMOVE)
    private List<DetalleCompraModel> productosCompra;

    @ManyToOne
    @JoinColumn(name = "proveedor")
    @JsonIgnore
    private ProveedorModel proveedor;
}
