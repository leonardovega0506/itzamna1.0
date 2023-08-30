package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import mx.veterinaria.chichen.itzamna.itzamna10.model.ServiciosModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IServiciosRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IServiciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosServiceImpl implements IServiciosService {

    @Autowired
    private IServiciosRepository iServicios;

    @Override
    public List<ServiciosModel> findAllServicios() {
        return iServicios.findAll();
    }

    @Override
    public Optional<ServiciosModel> findServiciosById(Long idServicios) {
        return iServicios.findById(idServicios);
    }

    @Override
    public ServiciosModel saveServicios(ServiciosModel servicio) {
        return iServicios.save(servicio);
    }

    @Override
    public void updateServicio(ServiciosModel servicio) {
        iServicios.save(servicio);
    }

    @Override
    public void deleteServicioById(Long idServicio) {
        iServicios.deleteById(idServicio);
    }
}
