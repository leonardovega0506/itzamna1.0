package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import lombok.extern.slf4j.Slf4j;
import mx.veterinaria.chichen.itzamna.itzamna10.exception.ResourceNotFoundException;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ServiciosDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ServiciosPacientesDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ServiciosModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ServiciosPacientesModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IServiciosRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ServiciosPacientesResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ServiciosResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IServiciosService;
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

@Slf4j
@Service
public class ServiciosServiceImpl implements IServiciosService {


    @Autowired
    private IServiciosRepository iServicios;

     @Autowired
     private ModelMapper modelMapper;

    @Override
    public ServiciosResponse getAllServicios(int numPage, int sizePage, String orderBy, String sortDir) {
        //Generamos la paginacion
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(orderBy).ascending():Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(numPage,sizePage,sort);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL NUMERO DE PAGINA, {}", numPage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL TAMAÑO DE PAGINA, {}", sizePage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA ORGANZAZCION, {}", orderBy);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA FORMA, {}", sortDir);
        //Buscamos y mapeamos a nuestro DTO
        Page<ServiciosModel> servicios = iServicios.findAll(pageable);
        List<ServiciosModel> listaServicios = servicios.getContent();
        List<ServiciosDTO> contenido = listaServicios
                .stream()
                .map(servicio -> mapearDTOEntidad(servicio))
                .collect(Collectors.toList());

        log.info("OBTENEMOS LA LISTA MAPEADA A DTO");
        //Agregamos el contenido a nuestro response
        ServiciosResponse response = new ServiciosResponse();
        response.setContent(contenido);
        response.setAllElements(servicios.getTotalElements());
        response.setAllPage(servicios.getTotalPages());
        response.setNumPage(servicios.getNumber());
        response.setSizePage(servicios.getSize());
        response.setLast(servicios.isLast());
        log.info("SE REGRESA LA INFORMACION DEL RESPONSE");
        return response;
    }

    @Override
    public ServiciosDTO getServicioByClave(String clave) {
        ServiciosModel servicioBuscado = iServicios.findByClaveServicio(clave).orElseThrow(()-> new ResourceNotFoundException("Servicio","clave",clave));
        return mapearDTOEntidad(servicioBuscado);
    }

    @Override
    public ServiciosDTO getServicioById(Long idServicio) {
        ServiciosModel servicioBuscado = iServicios.findById(idServicio).orElseThrow(()-> new ResourceNotFoundException("Servicio","Id",idServicio));
        return mapearDTOEntidad(servicioBuscado);
    }

    @Override
    public ServiciosDTO saveServicios(ServiciosDTO servicio) {
        ServiciosModel servicioNuevo = iServicios.save(mapearEntidadDTO(servicio));
        return mapearDTOEntidad(servicioNuevo);
    }

    @Override
    public void updateServicio(ServiciosDTO servicio) {
        ServiciosModel servicioBuscado = iServicios.findById(servicio.getIdServicio()).orElseThrow(()-> new ResourceNotFoundException("Servicio","Id",servicio.getIdServicio()));
        iServicios.save(servicioBuscado);
    }

    @Override
    public void deleteServicioById(Long idServicio) {
        ServiciosModel servicioBuscado = iServicios.findById(idServicio).orElseThrow(()-> new ResourceNotFoundException("Servicio","Id",idServicio));
        iServicios.delete(servicioBuscado);
    }

    private ServiciosDTO mapearDTOEntidad(ServiciosModel serviciosModel){
        ServiciosDTO serviciosDTO = modelMapper.map(serviciosModel, ServiciosDTO.class);
        return serviciosDTO;
    }

    private ServiciosModel mapearEntidadDTO(ServiciosDTO serviciosDTO){
        ServiciosModel serviciosModel = modelMapper.map(serviciosDTO,ServiciosModel.class);
        return serviciosModel;
    }
}
