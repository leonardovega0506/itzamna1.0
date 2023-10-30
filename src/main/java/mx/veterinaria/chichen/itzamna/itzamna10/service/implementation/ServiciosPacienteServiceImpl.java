package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ServiciosDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ServiciosPacientesDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ServiciosPacientesModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IServiciosPacientesRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ServiciosPacientesResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IServiciosPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosPacienteServiceImpl implements IServiciosPacienteService {


    @Override
    public ServiciosPacientesResponse getAllServiciosP(int numPage, int sizePage, String orderBy, String sortDir) {
        return null;
    }

    @Override
    public ServiciosPacientesResponse getAllServiciosByPaciente(int numPage, int sizePage, String orderBy, String sortDir, Long idPaciente) {
        return null;
    }

    @Override
    public ServiciosPacientesDTO getPacienteById(Long idPaciente) {
        return null;
    }

    @Override
    public ServiciosPacientesDTO saveServicioPacinte(ServiciosDTO servicio) {
        return null;
    }

    @Override
    public void updateServiciosPacientes(ServiciosDTO servicio) {

    }

    @Override
    public void deleteServiciosPaciente(Long idServiciosPaciente) {

    }
}
