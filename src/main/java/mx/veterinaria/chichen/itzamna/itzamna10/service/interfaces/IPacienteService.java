package mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.PacientesDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.PacientesModel;
import mx.veterinaria.chichen.itzamna.itzamna10.response.PacienteResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ProductoResponse;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {


    PacienteResponse getAllPacientes(int numPage, int sizePage, String orderBy, String sortDir);

    PacienteResponse getAllPacienteByPropietario(int numPage, int size, String orderBy, String sortDir,Long idPropietario);

    PacienteResponse getPacienteByNombre(int numPage, int numSize, String orderBy, String sortDir, String nombre);

    PacientesDTO getPacienteById(Long idPaciente);

    PacientesDTO savePaciente(PacientesDTO pacientesDTO, Long idPropietario);

    void updatePaciente(PacientesDTO paciente);

    void deletePacienteById(Long idPaciente);
}
