package mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces;

import mx.veterinaria.chichen.itzamna.itzamna10.model.PacientesModel;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {

    List<PacientesModel> findAllPaciente();

    List<PacientesModel> findAllPacienteByPropietarioId(Long idPropietario);

    Optional<PacientesModel> findPacienteById(Long idPaciente);

    PacientesModel savePaciente(PacientesModel paciente);

    void updatePaciente(PacientesModel paciente);

    void deletePacienteById(Long idPaciente);
}
