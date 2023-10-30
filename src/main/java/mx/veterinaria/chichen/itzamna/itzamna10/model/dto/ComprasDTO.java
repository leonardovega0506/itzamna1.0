package mx.veterinaria.chichen.itzamna.itzamna10.model.dto;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
public class ComprasDTO {


    private Long idCompra;
    private List<DetalleCompraDTO> productosCompra;
    private Double totalCompra;
    private LocalDate fechaCompra;
    private String facturaCompra;
    private String notaCompra;
    private ProveedorDTO proveedor;
}
