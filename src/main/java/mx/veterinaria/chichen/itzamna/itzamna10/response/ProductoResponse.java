package mx.veterinaria.chichen.itzamna.itzamna10.response;

import lombok.Data;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ProductosDTO;

import java.util.List;

@Data
public class ProductoResponse {
    private List<ProductosDTO> content;
    private int numPage;
    private int sizePage;
    private long allElements;
    private int allPage;
    private boolean last;
}
