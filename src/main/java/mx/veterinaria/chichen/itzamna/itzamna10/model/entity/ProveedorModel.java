package mx.veterinaria.chichen.itzamna.itzamna10.model.entity;

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

    @OneToMany
    private List<ComprasModel> compras;

    @OneToMany
    private List<ProductosModel> productos;

}
