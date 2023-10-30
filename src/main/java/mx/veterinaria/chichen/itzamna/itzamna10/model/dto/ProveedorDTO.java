package mx.veterinaria.chichen.itzamna.itzamna10.model.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class ProveedorDTO {

    private Long idProveedor;
    private String nombreProveedor;
    private String tipoProveedor;
    private String telefonoProveedor;
    private String emailProveedor;
    private List<ComprasDTO> compras;
    private List<ProductosDTO> productos;

}
