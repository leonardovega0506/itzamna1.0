package mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ComprasDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.DetalleCompraDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.DetalleVentaDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.VentasDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ComprasResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.response.VentasResponse;

import java.util.List;

public interface IVentaService {
    VentasResponse getAllVenta(int numPage, int sizePage, String orderBy, String sortDir);
    List<DetalleVentaDTO> getDetallesByVenta(Long iVenta);
    VentasDTO getVentaById(Long idVenta);
    VentasDTO saveVenta(VentasDTO ventasDTO);
    void updateVenta(VentasDTO venta);
    void deleteVentaById(Long idVenta);
}
