package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.DiarioDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.DiarioModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IDiarioRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.response.DiarioResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IDiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DiarioServiceImpl implements IDiarioService {


    @Override
    public DiarioResponse getAllDiario(int numPage, int sizePage, String orderBy, String sortDir) {
        return null;
    }

    @Override
    public DiarioDTO getDiarioById(Long idDiario) {
        return null;
    }

    @Override
    public DiarioDTO saveDiairio(DiarioDTO diarioDTO) {
        return null;
    }

    @Override
    public void updateDiairio(DiarioDTO diairio) {

    }

    @Override
    public void deleteDiarioById(Long idDiairio) {

    }

    @Override
    public void assignDiairioToHistorico(DiarioDTO diarioDTO) {

    }
}
