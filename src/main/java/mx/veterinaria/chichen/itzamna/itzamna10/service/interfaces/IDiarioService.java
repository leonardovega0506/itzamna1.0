package mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces;

import mx.veterinaria.chichen.itzamna.itzamna10.model.DiarioModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IDiarioService {

    List<DiarioModel> findAllDiairios();

    List<DiarioModel> findAllDiariosByFecha(LocalDate fecha);

    Optional<DiarioModel> findDiairioById(Long idDiairio);

    DiarioModel saveDiairio(DiarioModel diario);

    void updateDiairio(DiarioModel diairio);

    void deleteDiarioById(Long idDiairio);

}
