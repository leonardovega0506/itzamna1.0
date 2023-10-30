package mx.veterinaria.chichen.itzamna.itzamna10.response;

import lombok.Data;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.PropietarioDTO;

import java.util.List;

@Data
public class PropietarioResponse {
    private List<PropietarioDTO> content;
    private int numPage;
    private int sizePage;
    private long allElements;
    private int allPage;
    private boolean last;
}
