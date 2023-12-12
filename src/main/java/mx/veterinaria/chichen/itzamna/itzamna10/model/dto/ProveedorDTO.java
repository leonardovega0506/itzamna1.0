package mx.veterinaria.chichen.itzamna.itzamna10.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties({"proveedor"})
    private List<ComprasDTO> compras;
    @JsonIgnore
    private List<ProductosDTO> productos;

}
