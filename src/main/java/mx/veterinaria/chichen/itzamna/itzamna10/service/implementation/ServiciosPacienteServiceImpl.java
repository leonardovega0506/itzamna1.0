package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import lombok.extern.slf4j.Slf4j;
import mx.veterinaria.chichen.itzamna.itzamna10.exception.ResourceNotFoundException;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ServiciosDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ServiciosPacientesDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ServiciosPacientesModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IServiciosPacientesRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ResponsivasResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ServiciosPacientesResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IServiciosPacienteService;
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
public class ServiciosPacienteServiceImpl implements IServiciosPacienteService {


    @Autowired
    private IServiciosPacientesRepository iServiciosP;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ServiciosPacientesResponse getAllServiciosP(int numPage, int sizePage, String orderBy, String sortDir) {
        //Generamos la paginacion
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(orderBy).ascending():Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(numPage,sizePage,sort);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL NUMERO DE PAGINA, {}", numPage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL TAMAÑO DE PAGINA, {}", sizePage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA ORGANZAZCION, {}", orderBy);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA FORMA, {}", sortDir);
        //Buscamos y mapeamos a nuestro DTO
        Page<ServiciosPacientesModel> servicios = iServiciosP.findAll(pageable);
        List<ServiciosPacientesModel> listaServicios = servicios.getContent();
        List<ServiciosPacientesDTO> contenido = listaServicios
                .stream()
                .map(servicio -> mapearDTOEntidad(servicio))
                .collect(Collectors.toList());

        log.info("OBTENEMOS LA LISTA MAPEADA A DTO");
        //Agregamos el contenido a nuestro response
        ServiciosPacientesResponse response = new ServiciosPacientesResponse();
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
    public ServiciosPacientesResponse getAllServiciosByPaciente(int numPage, int sizePage, String orderBy, String sortDir, Long idPaciente) {
        //Generamos la paginacion
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(orderBy).ascending():Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(numPage,sizePage,sort);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL NUMERO DE PAGINA, {}", numPage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL TAMAÑO DE PAGINA, {}", sizePage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA ORGANZAZCION, {}", orderBy);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA FORMA, {}", sortDir);
        //Buscamos y mapeamos a nuestro DTO
        Page<ServiciosPacientesModel> servicios = iServiciosP.findByPaciente_IdPaciente(idPaciente,pageable);
        List<ServiciosPacientesModel> listaServicios = servicios.getContent();
        List<ServiciosPacientesDTO> contenido = listaServicios
                .stream()
                .map(servicio -> mapearDTOEntidad(servicio))
                .collect(Collectors.toList());

        log.info("OBTENEMOS LA LISTA MAPEADA A DTO");
        //Agregamos el contenido a nuestro response
        ServiciosPacientesResponse response = new ServiciosPacientesResponse();
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
    public ServiciosPacientesDTO getPacienteById(Long idPaciente) {
        ServiciosPacientesModel serviciosBuscado = iServiciosP.findById(idPaciente).orElseThrow(()-> new ResourceNotFoundException("Servicio","Id",idPaciente));
        return mapearDTOEntidad(serviciosBuscado);
    }

    @Override
    public ServiciosPacientesDTO saveServicioPacinte(ServiciosPacientesDTO servicio) {
        ServiciosPacientesModel servicioNuevo = iServiciosP.save(mapearEntidadDTO(servicio));
        return mapearDTOEntidad(servicioNuevo);
    }

    @Override
    public void updateServiciosPacientes(ServiciosPacientesDTO servicio) {
        ServiciosPacientesModel serviciosBuscado = iServiciosP.findById(servicio.getIdServicioPaciente()).orElseThrow(()-> new ResourceNotFoundException("Servicio","Id",servicio.getIdServicioPaciente()));

        iServiciosP.save(serviciosBuscado);
    }

    @Override
    public void deleteServiciosPaciente(Long idServiciosPaciente) {
        ServiciosPacientesModel serviciosBuscado = iServiciosP.findById(idServiciosPaciente).orElseThrow(()-> new ResourceNotFoundException("Servicio","Id",idServiciosPaciente));
        iServiciosP.delete(serviciosBuscado);
    }

    private ServiciosPacientesDTO mapearDTOEntidad(ServiciosPacientesModel serviciosPacientesModel){
        ServiciosPacientesDTO serviciosPacientesDTO = modelMapper.map(serviciosPacientesModel,ServiciosPacientesDTO.class);
        return serviciosPacientesDTO;
    }

    private ServiciosPacientesModel mapearEntidadDTO(ServiciosPacientesDTO serviciosPacientesDTO){
        ServiciosPacientesModel serviciosPacientesModel = modelMapper.map(serviciosPacientesDTO,ServiciosPacientesModel.class);
        return serviciosPacientesModel;
    }
}
