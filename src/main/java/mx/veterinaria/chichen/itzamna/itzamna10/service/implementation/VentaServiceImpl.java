package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import lombok.extern.slf4j.Slf4j;
import mx.veterinaria.chichen.itzamna.itzamna10.exception.ResourceNotFoundException;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ComprasDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.DetalleVentaDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ServiciosDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.VentasDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.DetalleVentaModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ServiciosModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.VentasModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IDetalleVentasRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IVentaRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ServiciosResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.response.VentasResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IVentaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class VentaServiceImpl implements IVentaService {

    @Autowired
    private IVentaRepository iVenta;

    @Autowired
    private IDetalleVentasRepository iDetalle;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public VentasResponse getAllVenta(int numPage, int sizePage, String orderBy, String sortDir) {
        //Generamos la paginacion
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(orderBy).ascending():Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(numPage,sizePage,sort);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL NUMERO DE PAGINA, {}", numPage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL TAMAÑO DE PAGINA, {}", sizePage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA ORGANZAZCION, {}", orderBy);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA FORMA, {}", sortDir);
        //Buscamos y mapeamos a nuestro DTO
        Page<VentasModel> ventas = iVenta.findAll(pageable);
        List<VentasModel> listaVentas =ventas.getContent();
        List<VentasDTO> contenido = listaVentas
                .stream()
                .map(venta -> mapearDTOEntidad(venta))
                .collect(Collectors.toList());

        log.info("OBTENEMOS LA LISTA MAPEADA A DTO");
        //Agregamos el contenido a nuestro response
        VentasResponse response = new VentasResponse();
        response.setContent(contenido);
        response.setAllElements(ventas.getTotalElements());
        response.setAllPage(ventas.getTotalPages());
        response.setNumPage(ventas.getNumber());
        response.setSizePage(ventas.getSize());
        response.setLast(ventas.isLast());
        log.info("SE REGRESA LA INFORMACION DEL RESPONSE");
        return response;
    }

    @Override
    public List<DetalleVentaDTO> getDetallesByVenta(Long idVenta) {
        List<DetalleVentaModel> listaDetalles = iDetalle.findByVentas_IdVenta(idVenta);
        List<DetalleVentaDTO> listaDevuelta = listaDetalles.stream().map(detalle-> mapearDTOEntidad(detalle)).collect(Collectors.toList());
        return listaDevuelta;
    }

    @Override
    public VentasDTO getVentaById(Long idVenta) {
        VentasModel ventaBuscada = iVenta.findById(idVenta).orElseThrow(()-> new ResourceNotFoundException("Venta","Id",idVenta));
        return mapearDTOEntidad(ventaBuscada);
    }

    @Override
    public VentasDTO saveVenta(VentasDTO ventasDTO) {
        VentasModel ventaNueva = iVenta.save(mapearEntidadDTO(ventasDTO));
        return mapearDTOEntidad(ventaNueva);
    }

    @Override
    public void updateVenta(VentasDTO ventas) {
        VentasModel ventaBuscada = iVenta.findById(ventas.getIdVenta()).orElseThrow(()-> new ResourceNotFoundException("Venta","Id", ventas.getIdVenta()));
        iVenta.save(ventaBuscada);
    }

    @Override
    public void deleteVentaById(Long idVenta) {
        VentasModel ventaBuscada = iVenta.findById(idVenta).orElseThrow(()-> new ResourceNotFoundException("Venta","Id",idVenta));
        iVenta.delete(ventaBuscada);
    }

    private VentasModel mapearEntidadDTO(VentasDTO ventasDTO){
        VentasModel ventasModel = modelMapper.map(ventasDTO,VentasModel.class);
        return ventasModel;
    }

    private VentasDTO mapearDTOEntidad(VentasModel ventasModel){
        VentasDTO ventasDTO = modelMapper.map(ventasModel,VentasDTO.class);
        return ventasDTO;
    }

    private DetalleVentaModel mapearEntidadDTO(DetalleVentaDTO ventaDTO){
        DetalleVentaModel ventaModel = modelMapper.map(ventaDTO, DetalleVentaModel.class);
        return ventaModel;
    }

    private DetalleVentaDTO mapearDTOEntidad(DetalleVentaModel detalleVentaModel){
        DetalleVentaDTO detalleVentaDTO = modelMapper.map(detalleVentaModel, DetalleVentaDTO.class);
        return detalleVentaDTO;
    }

}
