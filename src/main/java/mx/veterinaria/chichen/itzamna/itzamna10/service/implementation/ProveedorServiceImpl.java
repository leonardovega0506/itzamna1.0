package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ProveedorDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ProveedorModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IProveedorRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ProveedorResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements IProveedorService {


    @Override
    public ProveedorResponse getAllProveedor(int numPage, int sizePage, String orderBy, String sortDir) {
        return null;
    }

    @Override
    public ProveedorResponse getAllProveedorByNombre(int numPage, int sizePage, String orderBy, String sortDir, String nombre) {
        return null;
    }

    @Override
    public ProveedorDTO getProveedorById(Long idProveedor) {
        return null;
    }

    @Override
    public ProveedorDTO saveProveedor(ProveedorDTO proveedor) {
        return null;
    }

    @Override
    public void updateProveedor(ProveedorDTO proveedor) {

    }

    @Override
    public void deleteProveedorById(long idProveedor) {

    }
}
