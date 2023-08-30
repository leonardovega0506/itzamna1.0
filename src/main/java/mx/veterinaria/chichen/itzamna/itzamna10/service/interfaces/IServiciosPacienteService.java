package mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces;

import mx.veterinaria.chichen.itzamna.itzamna10.model.ServiciosModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.ServiciosPacientesModel;

import java.util.List;
import java.util.Optional;

public interface IServiciosPacienteService {

    List<ServiciosPacientesModel> findAllServicios();

    List<ServiciosPacientesModel> findAllServiciosByPacienteId(Long idPaciente);

    Optional<ServiciosPacientesModel> findById(Long idServicioP);

    ServiciosPacientesModel saveServicioPacinte(ServiciosPacientesModel servicio);

    void updateServiciosPacientes(ServiciosPacientesModel servicio);

    void deleteServiciosPaciente(Long idServiciosPaciente);
}
