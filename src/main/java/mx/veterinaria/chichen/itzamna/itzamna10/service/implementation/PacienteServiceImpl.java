package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import lombok.extern.slf4j.Slf4j;
import mx.veterinaria.chichen.itzamna.itzamna10.exception.ResourceNotFoundException;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.DiarioDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.PacientesDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.DiarioModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.PacientesModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.PropietarioModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IPacienteRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IPropietarioRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.response.DiarioResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.response.PacienteResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ProductoResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IPacienteService;
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
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private IPacienteRepository iPaciente;

    @Autowired
    private IPropietarioRepository iPropietario;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PacienteResponse getAllPacientes(int numPage, int sizePage, String orderBy, String sortDir) {
        //Generamos la paginacion
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(orderBy).ascending():Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(numPage,sizePage,sort);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL NUMERO DE PAGINA, {}", numPage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL TAMAÑO DE PAGINA, {}", sizePage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA ORGANZAZCION, {}", orderBy);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA FORMA, {}", sortDir);
        //Buscamos y mapeamos a nuestro DTO
        Page<PacientesModel> pacientes =iPaciente.findAll(pageable);
        List<PacientesModel> listaPacientes = pacientes.getContent();
        List<PacientesDTO> contenido = listaPacientes
                .stream()
                .map(paciente -> mapearDTOEntidad(paciente))
                .collect(Collectors.toList());

        log.info("OBTENEMOS LA LISTA MAPEADA A DTO");
        //Agregamos el contenido a nuestro response
        PacienteResponse pacienteResponse = new PacienteResponse();
        pacienteResponse.setContent(contenido);
        pacienteResponse.setNumPage(pacientes.getNumber());
        pacienteResponse.setSizePage(pacientes.getSize());
        pacienteResponse.setAllPage(pacientes.getTotalPages());
        pacienteResponse.setAllElements(pacientes.getTotalElements());
        log.info("SE REGRESA LA INFORMACION DEL RESPONSE");
        return pacienteResponse;
    }

    @Override
    public PacienteResponse getAllPacienteByPropietario(int numPage, int size, String orderBy, String sortDir, Long idPropietario) {
        //Generamos la paginacion
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(orderBy).ascending():Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(numPage,size,sort);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL NUMERO DE PAGINA, {}", numPage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL TAMAÑO DE PAGINA, {}", size);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA ORGANZAZCION, {}", orderBy);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA FORMA, {}", sortDir);
        //Buscamos y mapeamos a nuestro DTO
        Page<PacientesModel> pacientes = iPaciente.findByPropietario_IdPropietario(idPropietario,pageable);
        List<PacientesModel> listaPacientes = pacientes.getContent();
        List<PacientesDTO> contenido = listaPacientes
                .stream()
                .map(paciente -> mapearDTOEntidad(paciente))
                .collect(Collectors.toList());

        log.info("OBTENEMOS LA LISTA MAPEADA A DTO");
        //Agregamos el contenido a nuestro response
        PacienteResponse pacienteResponse = new PacienteResponse();
        pacienteResponse.setContent(contenido);
        pacienteResponse.setNumPage(pacientes.getNumber());
        pacienteResponse.setSizePage(pacientes.getSize());
        pacienteResponse.setAllPage(pacientes.getTotalPages());
        pacienteResponse.setAllElements(pacientes.getTotalElements());
        log.info("SE REGRESA LA INFORMACION DEL RESPONSE");
        return pacienteResponse;
    }

    @Override
    public PacienteResponse getPacienteByNombre(int numPage, int numSize, String orderBy, String sortDir, String nombre) {
        //Generamos la paginacion
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(orderBy).ascending():Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(numPage,numSize,sort);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL NUMERO DE PAGINA, {}", numPage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL TAMAÑO DE PAGINA, {}", numPage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA ORGANZAZCION, {}", orderBy);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA FORMA, {}", sortDir);
        //Buscamos y mapeamos a nuestro DTO
        Page<PacientesModel> pacientes =iPaciente.findAll(pageable);
        List<PacientesModel> listaPacientes = pacientes.getContent();
        List<PacientesDTO> contenido = listaPacientes
                .stream().filter(paciente -> paciente.getNombrePaciente().contains(nombre))
                .map(paciente -> mapearDTOEntidad(paciente))
                .collect(Collectors.toList());

        log.info("OBTENEMOS LA LISTA MAPEADA A DTO");
        //Agregamos el contenido a nuestro response
        PacienteResponse pacienteResponse = new PacienteResponse();
        pacienteResponse.setContent(contenido);
        pacienteResponse.setNumPage(pacientes.getNumber());
        pacienteResponse.setSizePage(pacientes.getSize());
        pacienteResponse.setAllPage(pacientes.getTotalPages());
        pacienteResponse.setAllElements(pacientes.getTotalElements());
        log.info("SE REGRESA LA INFORMACION DEL RESPONSE");
        return pacienteResponse;
    }

    @Override
    public PacientesDTO getPacienteById(Long idPaciente) {
        PacientesModel pacienteBuscado = iPaciente.findById(idPaciente).orElseThrow(()-> new ResourceNotFoundException("Paciente","id",idPaciente));

        return mapearDTOEntidad(pacienteBuscado);
    }

    @Override
    public PacientesDTO savePaciente(PacientesDTO pacientesDTO, Long idPropietario) {
        PropietarioModel propietarioBuscado = iPropietario.findById(idPropietario).orElseThrow(()->new ResourceNotFoundException("propietario","id",idPropietario));
        PacientesModel pacienteNuevo = mapearEntidadDTO(pacientesDTO);
        pacienteNuevo.setPropietario(propietarioBuscado);
        iPaciente.save(pacienteNuevo);
        return mapearDTOEntidad(pacienteNuevo);
    }

    @Override
    public void updatePaciente(PacientesDTO paciente) {
        PacientesModel pacienteBuscado = iPaciente.findById(paciente.getIdPaciente()).orElseThrow(()-> new ResourceNotFoundException("Paciente","id",paciente.getIdPaciente()));
        iPaciente.save(mapearEntidadDTO(paciente));
    }

    @Override
    public void deletePacienteById(Long idPaciente) {
        PacientesModel pacienteBuscado = iPaciente.findById(idPaciente).orElseThrow(()-> new ResourceNotFoundException("Paciente","id",idPaciente));
        iPaciente.delete(pacienteBuscado);
    }

    private PacientesDTO mapearDTOEntidad(PacientesModel pacientesModel){
        PacientesDTO pacientesDTO = modelMapper.map(pacientesModel,PacientesDTO.class);
        return pacientesDTO;
    }

    private PacientesModel mapearEntidadDTO(PacientesDTO pacientesDTO){
        PacientesModel pacientesModel = modelMapper.map(pacientesDTO,PacientesModel.class);
        return pacientesModel;
    }
}
