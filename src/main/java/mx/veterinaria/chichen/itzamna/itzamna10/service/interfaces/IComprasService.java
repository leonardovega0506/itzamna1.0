package mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ComprasDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.DetalleCompraDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ComprasModel;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ComprasResponse;

import java.util.List;
import java.util.Optional;

public interface IComprasService {



    ComprasResponse getAllCompras(int numPage, int sizePage, String orderBy, String sortDir);
    ComprasResponse getAllCompraseByProveedor(int numPage, int sizPage, String orderBy, String sortDir, Long idProveedor);
    List<DetalleCompraDTO> getDetallesByCompra(Long idCompra);
    ComprasDTO getCompraById(Long idCompra);
    ComprasDTO getcompraByNotaCompra(String notaCompra);
    ComprasDTO saveCompra(ComprasDTO comprasDTO);
    void updateCompra(ComprasDTO compras);
    void deleteCompraById(Long idCompra);
}
