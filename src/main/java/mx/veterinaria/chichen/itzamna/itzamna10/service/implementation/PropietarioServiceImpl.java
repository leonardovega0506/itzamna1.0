package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import mx.veterinaria.chichen.itzamna.itzamna10.model.PropietarioModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IPropietarioRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IPropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropietarioServiceImpl implements IPropietarioService {

    @Autowired
    private IPropietarioRepository iPropietario;

    @Override
    public List<PropietarioModel> findAllPropietarios() {
        return iPropietario.findAll();
    }

    @Override
    public Optional<PropietarioModel> findPropietarioById(Long idPropietarioP) {
        return iPropietario.findById(idPropietarioP);
    }

    @Override
    public PropietarioModel savePropietario(PropietarioModel propietario) {
        return iPropietario.save(propietario);
    }

    @Override
    public void updatePropietario(PropietarioModel propietari) {
        iPropietario.save(propietari);
    }

    @Override
    public void deleteByIdPropietario(Long idPropietario) {
        iPropietario.deleteById(idPropietario);
    }
}
