package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import lombok.extern.slf4j.Slf4j;
import mx.veterinaria.chichen.itzamna.itzamna10.exception.ResourceNotFoundException;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ComprasDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.DetalleCompraDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.DiarioDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ComprasModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.DetalleCompraModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.DiarioModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IComprasRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IDetalleComprasRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ComprasResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IComprasService;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IDiarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ComprasServiceImpl implements IComprasService {

    @Autowired
    private IComprasRepository iCompras;

    @Autowired
    private IDetalleComprasRepository iDetalle;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IDiarioService sDiario;


    //Obtener la lista de todas las compras
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

    //Obtener la lista de compras por proveedor
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

    //Obtener los detalles de la compra
    @Override
    public List<DetalleCompraDTO> getDetallesByCompra(Long idCompra) {
        List<DetalleCompraModel> listaDetalles = iDetalle.findByProveedorDetalle_Compras_IdCompra(idCompra);
        log.info("OBTENE,OS LA LISTA DE LOS DETALLES");
        List<DetalleCompraDTO> contenido = listaDetalles.stream().map(detalle -> mapearDTOEntidad(detalle)).collect(Collectors.toList());
        return contenido;
    }

    //Obtener la nota por id
    @Override
    public ComprasDTO getCompraById(Long idCompra) {
        ComprasModel compraBuscada = iCompras.findById(idCompra).orElseThrow( ()-> new ResourceNotFoundException("Compras","id",idCompra));
        log.info("OBTENCION DE LA COMPRA POR ID");
        return mapearDTOEntidad(compraBuscada);
    }

    //Ibtener la compra por nota de compra
    @Override
    public ComprasDTO getcompraByNotaCompra(String notaCompra) {
        ComprasModel compraBuscada = iCompras.findByNotaCompra(notaCompra).orElseThrow(()-> new ResourceNotFoundException("Compra","notaCompra",notaCompra));
        log.info("OBTENCION DE LA COMPRA POR NOTA");
        return mapearDTOEntidad(compraBuscada);
    }

    //Guardar la compra
    @Override
    public ComprasDTO saveCompra(ComprasDTO comprasDTO) {
        ComprasModel compraNueva = iCompras.save(mapearEntidadDTO(comprasDTO));

        //Asignamos una compra
        DiarioModel diarioModel = new DiarioModel();
        diarioModel.setCompras(compraNueva);
        diarioModel.setFechaDiario(LocalDate.now());
        diarioModel.setValorDiario(compraNueva.getTotalCompra());

        //Guardamos una compra en el diario
        DiarioDTO diarioDTO = sDiario.saveDiario(mapearDTOEntidad(diarioModel));
        log.info("COMPRA GUARDADA");
        return mapearDTOEntidad(compraNueva);
    }

    //Actualizar la compra
    @Override
    public void updateCompra(ComprasDTO compras) {
        ComprasModel comprasBuscada = iCompras.findById(compras.getIdCompra()).orElseThrow(()->new ResourceNotFoundException("Compras","id", compras.getIdCompra()));
        log.info("COMPRA ACTUALIZADA");
        iCompras.save(comprasBuscada);
    }

    //Borrar la compra por id
    @Override
    public void deleteCompraById(Long idCompra) {
        ComprasModel compraBuscada = iCompras.findById(idCompra).orElseThrow(()->new ResourceNotFoundException("Compras","id",idCompra));
        log.info("COMPRA ELIMINADA");
        iCompras.delete(compraBuscada);
    }

    //Mapear de entidad a dto - compras
    private ComprasDTO mapearDTOEntidad(ComprasModel comprasModel){
        ComprasDTO comprasDTO = modelMapper.map(comprasModel, ComprasDTO.class);
        return comprasDTO;
    }

    //Mapear de dto a entidad - compras
    private ComprasModel mapearEntidadDTO(ComprasDTO comprasDTO){
        ComprasModel comprasModel = modelMapper.map(comprasDTO,ComprasModel.class);
        return comprasModel;
    }

    //Mapear de entidad a dto - detalle
    private DetalleCompraDTO mapearDTOEntidad(DetalleCompraModel detalleCompraModel){
        DetalleCompraDTO detalleCompraDTO = modelMapper.map(detalleCompraModel, DetalleCompraDTO.class);
        return detalleCompraDTO;
    }

    //Mapear de dto a entidad - detalle
    private DetalleCompraModel mapearEntidadDTO(DetalleCompraDTO detalleCompraDTO){
        DetalleCompraModel detalleCompraModel = modelMapper.map(detalleCompraDTO, DetalleCompraModel.class);
        return detalleCompraModel;
    }

    private DiarioDTO mapearDTOEntidad(DiarioModel diarioModel){
        DiarioDTO diarioDTO = modelMapper.map(diarioModel,DiarioDTO.class);
        return diarioDTO;
    }

    private DiarioModel mapearEntidadDTO(DiarioDTO diarioDTO){
        DiarioModel diarioModel = modelMapper.map(diarioDTO,DiarioModel.class);
        return diarioModel;
    }
}
