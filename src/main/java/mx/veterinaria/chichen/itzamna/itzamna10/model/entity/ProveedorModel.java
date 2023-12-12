package mx.veterinaria.chichen.itzamna.itzamna10.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_proveedor")
public class ProveedorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long idProveedor;

    @Column(name = "nombre_proveedor")
    private String nombreProveedor;

    @Column(name = "tipo_proveedor")
    private String tipoProveedor;

    @Column(name = "telefono_proveedor")
    private String telefonoProveedor;

    @Column(name = "email_proveedor")
    private String emailProveedor;

    @JsonIgnore
    @OneToMany(mappedBy = "proveedor")
    private List<ComprasModel> compras;


    @OneToMany(mappedBy = "proveedor",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<ProductosModel> productos;

}
