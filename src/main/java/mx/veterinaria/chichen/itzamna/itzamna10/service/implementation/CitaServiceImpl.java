package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import lombok.extern.slf4j.Slf4j;
import mx.veterinaria.chichen.itzamna.itzamna10.exception.ResourceNotFoundException;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.CitasDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ComprasDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.CitasModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ComprasModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.ICitaRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.response.CitasResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ComprasResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.ICitaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CitaServiceImpl implements ICitaService {

    @Autowired
    private ICitaRepository iCita;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CitasDTO> getCitasByMonth(LocalDate month) {

        LocalDate primeroMes = YearMonth.from(month).atDay(1);
        LocalDate ultimoMes = YearMonth.from(month).atEndOfMonth();

        List<CitasModel> listaCitas = iCita.findByFechaCitaBetween(primeroMes,ultimoMes);
        List<CitasDTO> listaDevuelta = listaCitas.stream().map(cita -> mapearDTOEntidad(cita)).collect(Collectors.toList());
        return listaDevuelta;
    }

    @Override
    public CitasResponse getAllCitas(int numPage, int sizePage, String orderBy, String sortDir) {

        //Generamos la paginacion
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(orderBy).ascending():Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(numPage,sizePage,sort);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL NUMERO DE PAGINA, {}", numPage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL TAMAÑO DE PAGINA, {}", sizePage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA ORGANZAZCION, {}", orderBy);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA FORMA, {}", sortDir);
        //Buscamos y mapeamos a nuestro DTO
        Page<CitasModel> citas = iCita.findAll(pageable);
        List<CitasModel> listaCitas = citas.getContent();
        List<CitasDTO> contenido = listaCitas.stream().map(cita -> mapearDTOEntidad(cita)).collect(Collectors.toList());
        log.info("OBTENEMOS LA LISTA MAPEADA A DTO");
        //Agregamos el contenido a nuestro response
        CitasResponse citasResponse = new CitasResponse();
        citasResponse.setContent(contenido);

        citasResponse.setNumPage(citas.getNumber());
        citasResponse.setSizePage(citas.getSize());
        citasResponse.setAllElements(citas.getTotalElements());
        citasResponse.setAllPage(citas.getTotalPages());
        citasResponse.setLast(citasResponse.isLast());
        log.info("SE REGRESA LA INFORMACION DEL RESPONSE: {}",citasResponse);
        return citasResponse;

    }

    @Override
    public List<CitasDTO> getCitasByDay(LocalDate day) {


        List<CitasModel> listaCitas = iCita.findByFechaCita(day);
        List<CitasDTO> listaDevuelta = listaCitas.stream().map(cita -> mapearDTOEntidad(cita)).collect(Collectors.toList());
        return listaDevuelta;
    }

    @Override
    public CitasDTO getCitaById(Long idCita) {
        CitasModel citaTraida = iCita.findById(idCita).orElseThrow(()->new ResourceNotFoundException("Cita","Id",idCita));
        return mapearDTOEntidad(citaTraida);
    }

    @Override
    public CitasDTO saveCita(CitasDTO citasDTO) {
        CitasModel citaNueva = iCita.save(mapearEntidad(citasDTO));
        return mapearDTOEntidad(citaNueva);
    }

    @Override
    public void updateCita(CitasDTO citasDTO) {
        CitasModel citaTraida = iCita.findById(citasDTO.getIdCita()).orElseThrow(()->new ResourceNotFoundException("Cita","Id",citasDTO.getIdCita()));

        iCita.save(citaTraida);
    }

    @Override
    public void deleteCitaById(Long idCita) {
        CitasModel citaTraida = iCita.findById(idCita).orElseThrow(()->new ResourceNotFoundException("Cita","Id",idCita));
        iCita.delete(citaTraida);
    }

    private CitasDTO mapearDTOEntidad(CitasModel citasModel){
        CitasDTO citasDTO = modelMapper.map(citasModel, CitasDTO.class);
        return citasDTO;
    }

    private CitasModel mapearEntidad(CitasDTO citasDTO){
        CitasModel citasModel = modelMapper.map(citasDTO,CitasModel.class);
        return citasModel;
    }
}
