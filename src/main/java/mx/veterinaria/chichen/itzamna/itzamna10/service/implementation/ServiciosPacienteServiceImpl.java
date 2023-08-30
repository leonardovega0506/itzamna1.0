package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import mx.veterinaria.chichen.itzamna.itzamna10.model.ServiciosPacientesModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IServiciosPacientesRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IServiciosPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosPacienteServiceImpl implements IServiciosPacienteService {

    @Autowired
    private IServiciosPacientesRepository isPacientes;

    @Override
    public List<ServiciosPacientesModel> findAllServicios() {
        return isPacientes.findAll();
    }

    @Override
    public List<ServiciosPacientesModel> findAllServiciosByPacienteId(Long idPaciente) {
        return isPacientes.findByPaciente_IdPaciente(idPaciente);
    }

    @Override
    public Optional<ServiciosPacientesModel> findById(Long idServicioP) {
        return isPacientes.findById(idServicioP);
    }

    @Override
    public ServiciosPacientesModel saveServicioPacinte(ServiciosPacientesModel servicio) {
        return isPacientes.save(servicio);
    }

    @Override
    public void updateServiciosPacientes(ServiciosPacientesModel servicio) {
        isPacientes.save(servicio);
    }

    @Override
    public void deleteServiciosPaciente(Long idServiciosPaciente) {
        isPacientes.deleteById(idServiciosPaciente);
    }
}
