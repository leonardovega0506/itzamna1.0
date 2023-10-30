package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ServiciosDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ServiciosModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IServiciosRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ServiciosResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IServiciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosServiceImpl implements IServiciosService {


    @Override
    public ServiciosResponse getAllServicios(int numPage, int sizePage, String orderBy, String sortDir) {
        return null;
    }

    @Override
    public ServiciosDTO getServicioByClave(String clave) {
        return null;
    }

    @Override
    public ServiciosDTO getServicioById(Long idServicio) {
        return null;
    }

    @Override
    public ServiciosDTO saveServicios(ServiciosDTO servicio) {
        return null;
    }

    @Override
    public void updateServicio(ServiciosDTO servicio) {

    }

    @Override
    public void deleteServicioById(Long idServicio) {

    }
}
