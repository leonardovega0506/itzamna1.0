package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.PacientesDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.PacientesModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IPacienteRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.response.PacienteResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ProductoResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements IPacienteService {


    @Override
    public PacienteResponse getAllPacientes(int numPage, int sizePage, String orderBy, String sortDir) {
        return null;
    }

    @Override
    public ProductoResponse getAllPacienteByPropietario(int numPage, int size, String orderBy, String sortDir) {
        return null;
    }

    @Override
    public ProductoResponse getPacienteByNombre(int numPage, int numSize, String orderBy, String sortDir, String nombre) {
        return null;
    }

    @Override
    public PacientesDTO getPacienteById(Long idPaciente) {
        return null;
    }

    @Override
    public PacientesDTO savePaciente(PacientesDTO pacientesDTO) {
        return null;
    }

    @Override
    public void updatePaciente(PacientesDTO paciente) {

    }

    @Override
    public void deletePacienteById(Long idPaciente) {

    }
}
