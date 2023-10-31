package mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.PropietarioDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.PropietarioModel;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ProductoResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.response.PropietarioResponse;

import java.util.List;
import java.util.Optional;

public interface IPropietarioService {


    PropietarioResponse getAllPropietarios(int numPage, int sizePage, String orderBy, String sortDir);

    PropietarioResponse getllPropietariosByNombre(int numPage, int sizePage, String orderBy, String sortDir, String nombreProveedor);

    PropietarioDTO getPropietarioById(Long idPropietario);


    PropietarioDTO savePropietario(PropietarioDTO propietario);

    void updatePropietario(PropietarioDTO propietarip);

    void deleteByIdPropietario(Long idPropietario);
}
