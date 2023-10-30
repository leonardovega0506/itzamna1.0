package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.PropietarioDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.PropietarioModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IPropietarioRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ProductoResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IPropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropietarioServiceImpl implements IPropietarioService {


    @Override
    public ProductoResponse getAllPropietarios(int numPage, int sizePage, String orderBy, String sortDir) {
        return null;
    }

    @Override
    public ProductoResponse getllPropietariosByNombre(int numPage, int sizePage, String orderBy, String sortDir, String nombreProveedor) {
        return null;
    }

    @Override
    public PropietarioDTO getPropietarioById(Long idPropietario) {
        return null;
    }

    @Override
    public PropietarioDTO savePropietario(PropietarioDTO propietario) {
        return null;
    }

    @Override
    public void updatePropietario(PropietarioDTO propietarip) {

    }

    @Override
    public void deleteByIdPropietario(Long idPropietario) {

    }
}
