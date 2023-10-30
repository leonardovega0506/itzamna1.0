package mx.veterinaria.chichen.itzamna.itzamna10.response;

import lombok.Data;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ServiciosPacientesDTO;

import java.util.List;

@Data
public class ServiciosPacientesResponse {
    private List<ServiciosPacientesDTO> content;
    private int numPage;
    private int sizePage;
    private long allElements;
    private int allPage;
    private boolean last;
}
