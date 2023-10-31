package mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ServiciosDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ServiciosPacientesDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ServiciosPacientesModel;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ServiciosPacientesResponse;

import java.util.List;
import java.util.Optional;

public interface IServiciosPacienteService {


    ServiciosPacientesResponse getAllServiciosP(int numPage, int sizePage, String orderBy, String sortDir);
    ServiciosPacientesResponse getAllServiciosByPaciente(int numPage, int sizePage, String orderBy, String sortDir,Long idPaciente);
    ServiciosPacientesDTO getPacienteById(Long idPaciente);

    ServiciosPacientesDTO saveServicioPacinte(ServiciosPacientesDTO servicio);

    void updateServiciosPacientes(ServiciosPacientesDTO servicio);

    void deleteServiciosPaciente(Long idServiciosPaciente);
}
