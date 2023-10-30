package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import lombok.extern.slf4j.Slf4j;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ComprasDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.DetalleCompraDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ComprasModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.DetalleCompraModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IComprasRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IDetalleRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ComprasResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IComprasService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ComprasServiceImpl implements IComprasService {

    @Autowired
    private IComprasRepository iCompras;

    @Autowired
    private IDetalleRepository iDetalle;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ComprasResponse getAllCompras(int numPage, int sizePage, String orderBy, String sortDir) {
        //Generamos la paginacion
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(orderBy).ascending():Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(numPage,sizePage,sort);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL NUMERO DE PAGINA, {}", numPage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL TAMAÑO DE PAGINA, {}", sizePage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA ORGANZAZCION, {}", orderBy);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA FORMA, {}", sortDir);
        //Buscamos y mapeamos a nuestro DTO
        Page<ComprasModel> compras = iCompras.findAll(pageable);
        List<ComprasModel> listaCompras = compras.getContent();
        List<ComprasDTO> contenido = listaCompras.stream().map(compra -> mapearDTOEntidad(compra)).collect(Collectors.toList());
        log.info("OBTENEMOS LA LISTA MAPEADA A DTO");
        //Agregamos el contenido a nuestro response
        ComprasResponse comprasResponse = new ComprasResponse();
        comprasResponse.setContent(contenido);
        comprasResponse.setNumPage(compras.getNumber());
        comprasResponse.setSizePage(compras.getSize());
        comprasResponse.setAllElements(compras.getTotalElements());
        comprasResponse.setAllPage(compras.getTotalPages());
        comprasResponse.setLast(compras.isLast());
        log.info("SE REGRESA LA INFORMACION DEL RESPONSE: {}",comprasResponse);
        return comprasResponse;
    }

    @Override
    public ComprasResponse getAllCompraseByProveedor(int numPage, int sizePage, String orderBy, String sortDir, Long idProveedor) {
        //Generamos la paginacion
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(orderBy).ascending():Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(numPage,sizePage,sort);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL NUMERO DE PAGINA, {}", numPage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL TAMAÑO DE PAGINA, {}", sizePage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA ORGANZAZCION, {}", orderBy);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA FORMA, {}", sortDir);
        //Buscamos y mapeamos a nuestro DTO
        Page<ComprasModel> compras = iCompras.findAll(pageable);
        List<ComprasModel> listaCompras = compras.getContent();
        List<ComprasDTO> contenido = listaCompras
                .stream()
                .filter(compra -> compra.getProveedor().getIdProveedor().equals(idProveedor))
                .map(compra -> mapearDTOEntidad(compra))
                .collect(Collectors.toList());

        log.info("OBTENEMOS LA LISTA MAPEADA A DTO");
        //Agregamos el contenido a nuestro response
        ComprasResponse comprasResponse = new ComprasResponse();
        comprasResponse.setContent(contenido);
        comprasResponse.setNumPage(compras.getNumber());
        comprasResponse.setSizePage(compras.getSize());
        comprasResponse.setAllElements(compras.getTotalElements());
        comprasResponse.setAllPage(compras.getTotalPages());
        comprasResponse.setLast(compras.isLast());
        log.info("SE REGRESA LA INFORMACION DEL RESPONSE: {}",comprasResponse);
        return comprasResponse;
    }

    @Override
    public List<DetalleCompraDTO> getDetallesByCompra(Long idCompra) {
        List<DetalleCompraModel> listaDetalles = iDetalle.findByProveedorDetalle_Compras_IdCompra(idCompra);
        List<DetalleCompraDTO> contenido = listaDetalles.stream().map(detalle -> mapearDTOEntidad(detalle)).collect(Collectors.toList());
        return contenido;
    }

    @Override
    public ComprasDTO getCompraById(Long idCompra) {
        return null;
    }

    @Override
    public ComprasDTO getcompraByNotaCompra(String notaCompra) {
        return null;
    }

    @Override
    public ComprasDTO saveCompra(ComprasDTO comprasDTO) {
        return null;
    }

    @Override
    public void updateCompra(ComprasDTO compras) {

    }

    @Override
    public void deleteCompraById(Long idCompra) {

    }

    private ComprasDTO mapearDTOEntidad(ComprasModel comprasModel){
        ComprasDTO comprasDTO = modelMapper.map(comprasModel, ComprasDTO.class);
        return comprasDTO;
    }

    private ComprasModel mapearEntidadDTO(ComprasDTO comprasDTO){
        ComprasModel comprasModel = modelMapper.map(comprasDTO,ComprasModel.class);
        return comprasModel;
    }

    private DetalleCompraDTO mapearDTOEntidad(DetalleCompraModel detalleCompraModel){
        DetalleCompraDTO detalleCompraDTO = modelMapper.map(detalleCompraModel, DetalleCompraDTO.class);
        return detalleCompraDTO;
    }

    private DetalleCompraModel mapearEntidadDTO(DetalleCompraDTO detalleCompraDTO){
        DetalleCompraModel detalleCompraModel = modelMapper.map(detalleCompraDTO, DetalleCompraModel.class);
        return detalleCompraModel;
    }
}
