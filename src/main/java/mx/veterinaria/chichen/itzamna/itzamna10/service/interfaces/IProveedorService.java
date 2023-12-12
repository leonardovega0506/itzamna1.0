package mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ProveedorDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ProveedorModel;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ProveedorResponse;

import java.util.List;
import java.util.Optional;

public interface IProveedorService {


    ProveedorResponse getAllProveedor(int numPage, int sizePage, String orderBy, String sortDir);
    ProveedorResponse getAllProveedorByNombre(int numPage, int sizePage, String orderBy, String sortDir,String nombre);
    ProveedorDTO getProveedorById(Long idProveedor);
    ProveedorDTO saveProveedor(ProveedorDTO proveedor);
    ProveedorDTO updateProveedor(ProveedorDTO proveedor);

    void deleteProveedorById(long idProveedor);
}
