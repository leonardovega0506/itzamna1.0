package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import lombok.extern.slf4j.Slf4j;
import mx.veterinaria.chichen.itzamna.itzamna10.exception.ResourceNotFoundException;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ProveedorDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ResponsivasDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ProveedorModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ResponsivasModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IResposivaRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ProveedorResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ResponsivasResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IResposivasService;
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
public class ResponsivasServiceimpl implements IResposivasService {

    @Autowired
    private IResposivaRepository iResponsivas;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponsivasResponse getAllResponsivas(int numPage, int sizePage, String orderBy, String sortDir) {
        //Generamos la paginacion
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(orderBy).ascending():Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(numPage,sizePage,sort);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL NUMERO DE PAGINA, {}", numPage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL TAMAÑO DE PAGINA, {}", sizePage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA ORGANZAZCION, {}", orderBy);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA FORMA, {}", sortDir);
        //Buscamos y mapeamos a nuestro DTO
        Page<ResponsivasModel> responsivas =  iResponsivas.findAll(pageable);
        List<ResponsivasModel> listaResponsiva = responsivas.getContent();
        List<ResponsivasDTO> contenido = listaResponsiva
                .stream()
                .map(proveedor -> mapearDTOEntidad(proveedor))
                .collect(Collectors.toList());

        log.info("OBTENEMOS LA LISTA MAPEADA A DTO");
        //Agregamos el contenido a nuestro response
        ResponsivasResponse response = new ResponsivasResponse();
        response.setContent(contenido);
        response.setAllElements(responsivas.getTotalElements());
        response.setAllPage(responsivas.getTotalPages());
        response.setNumPage(responsivas.getNumber());
        response.setSizePage(responsivas.getSize());
        response.setLast(responsivas.isLast());
        log.info("SE REGRESA LA INFORMACION DEL RESPONSE");
        return response;
    }

    @Override
    public ResponsivasResponse getAllResponsivasByPaciente(int numPage, int sizePage, String orderBy, String sortDir, Long idPaciente) {
        //Generamos la paginacion
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(orderBy).ascending():Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(numPage,sizePage,sort);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL NUMERO DE PAGINA, {}", numPage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL TAMAÑO DE PAGINA, {}", sizePage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA ORGANZAZCION, {}", orderBy);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA FORMA, {}", sortDir);
        //Buscamos y mapeamos a nuestro DTO
        Page<ResponsivasModel> responsivas = iResponsivas.findByPaciente_IdPaciente(idPaciente,pageable);
        List<ResponsivasModel> listaResponsiva = responsivas.getContent();
        List<ResponsivasDTO> contenido = listaResponsiva
                .stream()
                .map(proveedor -> mapearDTOEntidad(proveedor))
                .collect(Collectors.toList());

        log.info("OBTENEMOS LA LISTA MAPEADA A DTO");
        //Agregamos el contenido a nuestro response
        ResponsivasResponse response = new ResponsivasResponse();
        response.setContent(contenido);
        response.setAllElements(responsivas.getTotalElements());
        response.setAllPage(responsivas.getTotalPages());
        response.setNumPage(responsivas.getNumber());
        response.setSizePage(responsivas.getSize());
        response.setLast(responsivas.isLast());
        log.info("SE REGRESA LA INFORMACION DEL RESPONSE");
        return response;
    }

    @Override
    public ResponsivasDTO getResponsivaById(Long idResponsiva) {
        ResponsivasModel responsivaBuscada = iResponsivas.findById(idResponsiva).orElseThrow(()->new ResourceNotFoundException("Responsiva","Id",idResponsiva));
        return mapearDTOEntidad(responsivaBuscada);
    }

    @Override
    public ResponsivasDTO saveResponsiva(ResponsivasDTO responsiva) {
        ResponsivasModel responsivaNueva = iResponsivas.save(mapearEntidadDTO(responsiva));
        return mapearDTOEntidad(responsivaNueva);
    }

    @Override
    public void deleteResposivaById(Long idResponsiva) {
        ResponsivasModel responsivaBuscada = iResponsivas.findById(idResponsiva).orElseThrow(()->new ResourceNotFoundException("Responsiva","Id",idResponsiva));
        iResponsivas.delete(responsivaBuscada);
    }

    private ResponsivasDTO mapearDTOEntidad(ResponsivasModel responsivasModel){
        ResponsivasDTO responsivasDTO = modelMapper.map(responsivasModel,ResponsivasDTO.class);
        return responsivasDTO;
    }

    private ResponsivasModel mapearEntidadDTO(ResponsivasDTO responsivasDTO){
        ResponsivasModel responsivasModel = modelMapper.map(responsivasDTO,ResponsivasModel.class);
        return responsivasModel;
    }
}
