package mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces;

import mx.veterinaria.chichen.itzamna.itzamna10.model.PropietarioModel;

import java.util.List;
import java.util.Optional;

public interface IPropietarioService {

    List<PropietarioModel> findAllPropietarios();

    Optional<PropietarioModel> findPropietarioById(Long idPropietarioP);

    PropietarioModel savePropietario(PropietarioModel propietario);

    void updatePropietario(PropietarioModel propietari);

    void deleteByIdPropietario(Long idPropietario);
}
