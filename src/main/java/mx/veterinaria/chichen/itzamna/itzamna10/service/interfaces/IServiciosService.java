package mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ServiciosDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ServiciosModel;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ServiciosResponse;

import java.util.List;
import java.util.Optional;

public interface IServiciosService {


    ServiciosResponse getAllServicios(int numPage, int sizePage, String orderBy, String sortDir);

    ServiciosDTO getServicioByClave(String clave);

    ServiciosDTO getServicioById(Long idServicio);

    ServiciosDTO saveServicios(ServiciosDTO servicio);

    void updateServicio(ServiciosDTO servicio);

    void deleteServicioById(Long idServicio);
}
