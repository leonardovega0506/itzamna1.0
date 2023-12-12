package mx.veterinaria.chichen.itzamna.itzamna10.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
public class ComprasDTO {


    private Long idCompra;
    private List<DetalleCompraDTO> productosCompra;
    private Double totalCompra;
    private String estatusCompra;
    private LocalDate fechaCompra;
    private String factura;
    private Boolean facturaCompra;
    private String notaCompra;
    @JsonIgnoreProperties({"compras"})
    private ProveedorDTO proveedor;
}
