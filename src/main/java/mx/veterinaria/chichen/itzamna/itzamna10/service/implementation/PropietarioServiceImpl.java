package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import lombok.extern.slf4j.Slf4j;
import mx.veterinaria.chichen.itzamna.itzamna10.exception.ResourceNotFoundException;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ProductosDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.PropietarioDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ProductosModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.PropietarioModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IPropietarioRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ProductoResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.response.PropietarioResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IPropietarioService;
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
public class PropietarioServiceImpl implements IPropietarioService {


    @Autowired
    private IPropietarioRepository iPropietario;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PropietarioResponse getAllPropietarios(int numPage, int sizePage, String orderBy, String sortDir) {
        //Generamos la paginacion
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(orderBy).ascending():Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(numPage,sizePage,sort);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL NUMERO DE PAGINA, {}", numPage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL TAMAÑO DE PAGINA, {}", sizePage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA ORGANZAZCION, {}", orderBy);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA FORMA, {}", sortDir);
        //Buscamos y mapeamos a nuestro DTO
        Page<PropietarioModel> propietarios = iPropietario.findAll(pageable);
        List<PropietarioModel> listaProductos = propietarios.getContent();
        List<PropietarioDTO> contenido = listaProductos
                .stream()
                .map(propietario -> mapearDTOEntidad(propietario))
                .collect(Collectors.toList());

        log.info("OBTENEMOS LA LISTA MAPEADA A DTO");
        //Agregamos el contenido a nuestro response
        PropietarioResponse propietarioResponse = new PropietarioResponse();
        propietarioResponse.setContent(contenido);
        propietarioResponse.setAllElements(propietarios.getTotalElements());
        propietarioResponse.setAllPage(propietarios.getTotalPages());
        propietarioResponse.setNumPage(propietarios.getNumber());
        propietarioResponse.setSizePage(propietarios.getSize());
        propietarioResponse.setLast(propietarios.isLast());
        log.info("SE REGRESA LA INFORMACION DEL RESPONSE");
        return propietarioResponse;
    }

    @Override
    public PropietarioResponse getllPropietariosByNombre(int numPage, int sizePage, String orderBy, String sortDir, String nombrePropietario) {
        //Generamos la paginacion
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(orderBy).ascending():Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(numPage,sizePage,sort);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL NUMERO DE PAGINA, {}", numPage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL TAMAÑO DE PAGINA, {}", sizePage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA ORGANZAZCION, {}", orderBy);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA FORMA, {}", sortDir);
        //Buscamos y mapeamos a nuestro DTO
        Page<PropietarioModel> propietarios = iPropietario.findAll(pageable);
        List<PropietarioModel> listaProductos = propietarios.getContent();
        List<PropietarioDTO> contenido = listaProductos
                .stream().filter(propietario -> propietario.getNombrePropietario().contains(nombrePropietario))
                .map(propietario -> mapearDTOEntidad(propietario))
                .collect(Collectors.toList());

        log.info("OBTENEMOS LA LISTA MAPEADA A DTO");
        //Agregamos el contenido a nuestro response
        PropietarioResponse propietarioResponse = new PropietarioResponse();
        propietarioResponse.setContent(contenido);
        propietarioResponse.setAllElements(propietarios.getTotalElements());
        propietarioResponse.setAllPage(propietarios.getTotalPages());
        propietarioResponse.setNumPage(propietarios.getNumber());
        propietarioResponse.setSizePage(propietarios.getSize());
        propietarioResponse.setLast(propietarios.isLast());
        log.info("SE REGRESA LA INFORMACION DEL RESPONSE");
        return propietarioResponse;
    }

    @Override
    public PropietarioDTO getPropietarioById(Long idPropietario) {
        PropietarioModel propietarioBuscado = iPropietario.findById(idPropietario).orElseThrow(()-> new ResourceNotFoundException("Propietario","id", idPropietario));
        return mapearDTOEntidad(propietarioBuscado);
    }

    @Override
    public PropietarioDTO savePropietario(PropietarioDTO propietario) {
        PropietarioModel propietarioNuevo = iPropietario.save(mapearEntidadDTO(propietario));
        return mapearDTOEntidad(propietarioNuevo);
    }

    @Override
    public void updatePropietario(PropietarioDTO propietario) {
        PropietarioModel propietarioBuscado = iPropietario.findById(propietario.getIdPropietario()).orElseThrow(()-> new ResourceNotFoundException("Propietario","id", propietario.getIdPropietario()));
        iPropietario.save(propietarioBuscado);
    }

    @Override
    public void deleteByIdPropietario(Long idPropietario) {
        PropietarioModel propietarioBuscado = iPropietario.findById(idPropietario).orElseThrow(()-> new ResourceNotFoundException("Propietario","id", idPropietario));
        iPropietario.delete(propietarioBuscado);
    }

    private PropietarioModel mapearEntidadDTO(PropietarioDTO propietarioDTO){
        PropietarioModel propietarioModel = modelMapper.map(propietarioDTO,PropietarioModel.class);
        return propietarioModel;
    }

    private PropietarioDTO mapearDTOEntidad(PropietarioModel propietarioModel){
        PropietarioDTO propietarioDTO = modelMapper.map(propietarioModel,PropietarioDTO.class);
        return propietarioDTO;
    }
}
