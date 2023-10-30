package mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.DiarioDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.DiarioModel;
import mx.veterinaria.chichen.itzamna.itzamna10.response.DiarioResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IDiarioService {

    DiarioResponse getAllDiario(int numPage, int sizePage, String orderBy, String sortDir);
    DiarioDTO getDiarioById(Long idDiario);
    DiarioDTO saveDiairio(DiarioDTO diarioDTO);

    void updateDiairio(DiarioDTO diairio);

    void deleteDiarioById(Long idDiairio);

    void assignDiairioToHistorico(DiarioDTO diarioDTO);

}
