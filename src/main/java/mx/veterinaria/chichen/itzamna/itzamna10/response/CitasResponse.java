package mx.veterinaria.chichen.itzamna.itzamna10.response;

import lombok.Data;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.CitasDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ComprasDTO;

import java.util.List;

@Data
public class CitasResponse {
    private List<CitasDTO> content;
    private int numPage;
    private int sizePage;
    private long allElements;
    private int allPage;
    private boolean last;
}
