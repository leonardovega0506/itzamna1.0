package mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces;

import mx.veterinaria.chichen.itzamna.itzamna10.model.ServiciosModel;

import java.util.List;
import java.util.Optional;

public interface IServiciosService {

    List<ServiciosModel> findAllServicios();

    Optional<ServiciosModel> findServiciosById(Long idServicios);

    ServiciosModel saveServicios(ServiciosModel servicio);

    void updateServicio(ServiciosModel servicio);

    void deleteServicioById(Long idServicio);
}
