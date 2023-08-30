package mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces;

import mx.veterinaria.chichen.itzamna.itzamna10.model.ProveedorModel;

import java.util.List;
import java.util.Optional;

public interface IProveedorService {

    List<ProveedorModel> findAllProveedores();

    Optional<ProveedorModel> findProveedorById(Long idProveedor);

    ProveedorModel saveProveedor(ProveedorModel proveedor);

    void updateProveedor(ProveedorModel proveedor);

    void deleteProveedorById(long idProveedor);
}
