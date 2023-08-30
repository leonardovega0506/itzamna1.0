package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import mx.veterinaria.chichen.itzamna.itzamna10.model.PacientesModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IPacienteRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private IPacienteRepository iPaciente;

    @Override
    public List<PacientesModel> findAllPaciente() {
        return iPaciente.findAll();
    }

    @Override
    public List<PacientesModel> findAllPacienteByPropietarioId(Long idPropietario) {
        return iPaciente.findByPropietario_IdPropietario(idPropietario);
    }

    @Override
    public Optional<PacientesModel> findPacienteById(Long idPaciente) {
        return iPaciente.findById(idPaciente);
    }

    @Override
    public PacientesModel savePaciente(PacientesModel paciente) {
        return iPaciente.save(paciente);
    }

    @Override
    public void updatePaciente(PacientesModel paciente) {
        iPaciente.save(paciente);
    }

    @Override
    public void deletePacienteById(Long idPaciente) {
        iPaciente.deleteById(idPaciente);
    }
}
