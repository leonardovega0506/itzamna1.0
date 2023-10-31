package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import lombok.extern.slf4j.Slf4j;
import mx.veterinaria.chichen.itzamna.itzamna10.exception.ResourceNotFoundException;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ComprasDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.DiarioDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.HistoricoDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ComprasModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.DiarioModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.HistoricoModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.SumaHistoricoModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IDiarioRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IHistoricoRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.ISumaHistoricoRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ComprasResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.response.DiarioResponse;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DiarioServiceImpl implements IDiarioService {


    @Autowired
    private IDiarioRepository iDiario;

    @Autowired
    private IHistoricoRepository iHistorico;

    @Autowired
    private ISumaHistoricoRepository iSuma;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DiarioResponse getAllDiario(int numPage, int sizePage, String orderBy, String sortDir) {
        //Generamos la paginacion
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(orderBy).ascending():Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(numPage,sizePage,sort);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL NUMERO DE PAGINA, {}", numPage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL TAMAÑO DE PAGINA, {}", sizePage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA ORGANZAZCION, {}", orderBy);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA FORMA, {}", sortDir);
        //Buscamos y mapeamos a nuestro DTO
        Page<DiarioModel> diario = iDiario.findAll(pageable);
        List<DiarioModel> listaDiairo = diario.getContent();
        List<DiarioDTO> contenido = listaDiairo
                .stream()
                .map(d -> mapearDTOEntidad(d))
                .collect(Collectors.toList());

        log.info("OBTENEMOS LA LISTA MAPEADA A DTO");
        //Agregamos el contenido a nuestro response
        DiarioResponse diarioResponse = new DiarioResponse();
        diarioResponse.setContent(contenido);
        diarioResponse.setNumPage(diario.getNumber());
        diarioResponse.setSizePage(diario.getSize());
        diarioResponse.setAllElements(diario.getTotalElements());
        diarioResponse.setAllPage(diario.getTotalPages());
        diarioResponse.setLast(diario.isLast());
        log.info("SE REGRESA LA INFORMACION DEL RESPONSE: {}",diarioResponse);
        return diarioResponse;
    }

    @Override
    public DiarioDTO getDiarioById(Long idDiario) {
        DiarioModel detalleDiario = iDiario.findById(idDiario).orElseThrow(
                ()->new ResourceNotFoundException("Diario","id",idDiario));
        return mapearDTOEntidad(detalleDiario);
    }

    @Override
    public DiarioDTO saveDiario(DiarioDTO diarioDTO) {
        DiarioModel diarioNuevo = iDiario.save(mapearEntidadDTO(diarioDTO));
        return mapearDTOEntidad(diarioNuevo);
    }

    @Override
    public void updateDiario(DiarioDTO diario) {
        DiarioModel detalleDiario = iDiario.findById(diario.getIdDiario()).orElseThrow(
                ()->new ResourceNotFoundException("Diario","id",diario.getIdDiario()));
        iDiario.save(detalleDiario);
    }

    @Override
    public void deleteDiarioById(Long idDiario) {
        DiarioModel detalleDiario = iDiario.findById(idDiario).orElseThrow(
                ()->new ResourceNotFoundException("Diario","id",idDiario));
        iDiario.delete(detalleDiario);
    }

    @Override
    public void assignDiairioToHistorico(LocalDate fechaDiario) {
        List<DiarioModel> listaFechaDiario = iDiario.findByFechaDiario(fechaDiario);
        List<DiarioDTO> contenido = listaFechaDiario.stream().map(diario -> mapearDTOEntidad(diario)).collect(Collectors.toList());
        List<HistoricoDTO> contenidoHistorico = contenido.stream().map(diarioDTO -> mapearHistorico(diarioDTO)).collect(Collectors.toList());
        SumaHistoricoModel sumaHistorico = new SumaHistoricoModel();
        Double venta = 0.0;
        Double compras = 0.0;
        for(var historico:contenidoHistorico){
            venta+= historico.getVentaHistorica().getTotalVenta();
            compras+=historico.getCompraHistorico().getTotalCompra();
        }
        sumaHistorico.setSumaTotal(venta-compras);
        List<HistoricoModel> contenidoSuma= contenidoHistorico.stream().map(sHistorico -> mapearDTOEntidad(sHistorico)).collect(Collectors.toList());
        sumaHistorico.setListaHistorico(contenidoSuma);
        sumaHistorico.setFechaTotal(fechaDiario);

        iHistorico.saveAll(contenidoSuma);
        iSuma.save(sumaHistorico);
        iDiario.deleteAll(listaFechaDiario);
    }

    private DiarioDTO mapearDTOEntidad(DiarioModel diarioModel){
        DiarioDTO diarioDTO = modelMapper.map(diarioModel,DiarioDTO.class);
        return diarioDTO;
    }

    private DiarioModel mapearEntidadDTO(DiarioDTO diarioDTO){
        DiarioModel diarioModel = modelMapper.map(diarioDTO,DiarioModel.class);
        return diarioModel;
    }

    private HistoricoDTO mapearHistorico(DiarioDTO diarioDTO) {
        HistoricoDTO historicoDTO = new HistoricoDTO();
        historicoDTO.setCompraHistorico(diarioDTO.getCompra());
        historicoDTO.setVentaHistorica(diarioDTO.getVentas());
        historicoDTO.setValorHistroico(diarioDTO.getValorDiario());
        historicoDTO.setFechaHistorico(diarioDTO.getFechaDiario());
        return historicoDTO;
    }

    private HistoricoModel mapearDTOEntidad(HistoricoDTO historicoDTO){
        HistoricoModel historicoModel = modelMapper.map(historicoDTO, HistoricoModel.class);
        return historicoModel;
    }
}
