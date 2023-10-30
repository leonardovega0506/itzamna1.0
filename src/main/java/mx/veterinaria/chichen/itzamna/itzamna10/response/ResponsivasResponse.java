package mx.veterinaria.chichen.itzamna.itzamna10.response;

import lombok.Data;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ResponsivasDTO;

import java.util.List;

@Data
public class ResponsivasResponse {
    private List<ResponsivasDTO> content;
    private int numPage;
    private int sizePage;
    private long allElements;
    private int allPage;
    private boolean last;
}
