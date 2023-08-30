package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import mx.veterinaria.chichen.itzamna.itzamna10.model.ProveedorModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IProveedorRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements IProveedorService {

    @Autowired
    private IProveedorRepository iProveedor;

    @Override
    public List<ProveedorModel> findAllProveedores() {
        return iProveedor.findAll();
    }

    @Override
    public Optional<ProveedorModel> findProveedorById(Long idProveedor) {
        return iProveedor.findById(idProveedor);
    }

    @Override
    public ProveedorModel saveProveedor(ProveedorModel proveedor) {
        return iProveedor.save(proveedor);
    }

    @Override
    public void updateProveedor(ProveedorModel proveedor) {
            iProveedor.save(proveedor);
    }

    @Override
    public void deleteProveedorById(long idProveedor) {
        iProveedor.deleteById(idProveedor);
    }
}
