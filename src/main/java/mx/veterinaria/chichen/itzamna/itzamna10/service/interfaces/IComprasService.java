package mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces;

import mx.veterinaria.chichen.itzamna.itzamna10.model.ComprasModel;

import java.util.List;
import java.util.Optional;

public interface IComprasService {

    List<ComprasModel> findAllCompras();

    List<ComprasModel> findAllComprasByProveedorId(Long idProveedor);

    Optional<ComprasModel> findCompraById(Long idCompra);

    Optional<ComprasModel> findCompraByNotaCompra(String notaCompra);

    ComprasModel saveCompra(ComprasModel compras);

    void updateCompra(ComprasModel compras);

    void deleteCompraById(Long idCompra);
}
