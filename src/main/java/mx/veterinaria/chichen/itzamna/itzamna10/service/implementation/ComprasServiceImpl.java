package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import mx.veterinaria.chichen.itzamna.itzamna10.model.ComprasModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IComprasRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComprasServiceImpl implements IComprasService {

    @Autowired
    private IComprasRepository iCompras;

    @Override
    public List<ComprasModel> findAllCompras() {
        return iCompras.findAll();
    }

    @Override
    public List<ComprasModel> findAllComprasByProveedorId(Long idProveedor) {
        return iCompras.findByProveedor_IdProveedor(idProveedor);
    }

    @Override
    public Optional<ComprasModel> findCompraById(Long idCompra) {
        return iCompras.findById(idCompra);
    }

    @Override
    public Optional<ComprasModel> findCompraByNotaCompra(String notaCompra) {
        return iCompras.findByNotaCompra(notaCompra);
    }

    @Override
    public ComprasModel saveCompra(ComprasModel compras) {
        return iCompras.save(compras);
    }

    @Override
    public void updateCompra(ComprasModel compras) {
        iCompras.save(compras);
    }

    @Override
    public void deleteCompraById(Long idCompra) {
        iCompras.deleteById(idCompra);
    }
}
