package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import lombok.extern.slf4j.Slf4j;
import mx.veterinaria.chichen.itzamna.itzamna10.exception.ResourceNotFoundException;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.PropietarioDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ProveedorDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.PropietarioModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ProveedorModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IProveedorRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.response.PropietarioResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ProveedorResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IProveedorService;
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
public class ProveedorServiceImpl implements IProveedorService {

    @Autowired
    private IProveedorRepository iProveedor;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProveedorResponse getAllProveedor(int numPage, int sizePage, String orderBy, String sortDir) {
        //Generamos la paginacion
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(orderBy).ascending():Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(numPage,sizePage,sort);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL NUMERO DE PAGINA, {}", numPage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL TAMAÑO DE PAGINA, {}", sizePage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA ORGANZAZCION, {}", orderBy);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA FORMA, {}", sortDir);
        //Buscamos y mapeamos a nuestro DTO
        Page<ProveedorModel> proveedores = iProveedor.findAll(pageable);
        List<ProveedorModel> listaProveedores = proveedores.getContent();
        List<ProveedorDTO> contenido = listaProveedores
                .stream()
                .map(proveedor -> mapearDTOEntidad(proveedor))
                .collect(Collectors.toList());

        log.info("OBTENEMOS LA LISTA MAPEADA A DTO");
        //Agregamos el contenido a nuestro response
        ProveedorResponse proveedorResponse = new ProveedorResponse();
        proveedorResponse.setContent(contenido);
        proveedorResponse.setAllElements(proveedores.getTotalElements());
        proveedorResponse.setAllPage(proveedores.getTotalPages());
        proveedorResponse.setNumPage(proveedores.getNumber());
        proveedorResponse.setSizePage(proveedores.getSize());
        proveedorResponse.setLast(proveedores.isLast());
        log.info("SE REGRESA LA INFORMACION DEL RESPONSE");
        return proveedorResponse;
    }

    @Override
    public ProveedorResponse getAllProveedorByNombre(int numPage, int sizePage, String orderBy, String sortDir, String nombre) {
        //Generamos la paginacion
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(orderBy).ascending():Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(numPage,sizePage,sort);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL NUMERO DE PAGINA, {}", numPage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL TAMAÑO DE PAGINA, {}", sizePage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA ORGANZAZCION, {}", orderBy);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA FORMA, {}", sortDir);
        //Buscamos y mapeamos a nuestro DTO
        Page<ProveedorModel> proveedores = iProveedor.findAll(pageable);
        List<ProveedorModel> listaProveedores = proveedores.getContent();
        List<ProveedorDTO> contenido = listaProveedores
                .stream().filter(proveedor -> proveedor.getNombreProveedor().contains(nombre))
                .map(proveedor -> mapearDTOEntidad(proveedor))
                .collect(Collectors.toList());

        log.info("OBTENEMOS LA LISTA MAPEADA A DTO");
        //Agregamos el contenido a nuestro response
        ProveedorResponse proveedorResponse = new ProveedorResponse();
        proveedorResponse.setContent(contenido);
        proveedorResponse.setAllElements(proveedores.getTotalElements());
        proveedorResponse.setAllPage(proveedores.getTotalPages());
        proveedorResponse.setNumPage(proveedores.getNumber());
        proveedorResponse.setSizePage(proveedores.getSize());
        proveedorResponse.setLast(proveedores.isLast());
        log.info("SE REGRESA LA INFORMACION DEL RESPONSE");
        return proveedorResponse;
    }

    @Override
    public ProveedorDTO getProveedorById(Long idProveedor) {
        ProveedorModel proveedorBuscado = iProveedor.findById(idProveedor).orElseThrow(()->new ResourceNotFoundException("Proveedor","id",idProveedor));
        return mapearDTOEntidad(proveedorBuscado);
    }

    @Override
    public ProveedorDTO saveProveedor(ProveedorDTO proveedor) {
        ProveedorModel proveedorNuevo = iProveedor.save(mapearEntidadDTO(proveedor));
        return mapearDTOEntidad(proveedorNuevo);
    }

    @Override
    public void updateProveedor(ProveedorDTO proveedor) {
        ProveedorModel proveedorBuscado = iProveedor.findById(proveedor.getIdProveedor()).orElseThrow(()->new ResourceNotFoundException("Proveedor","id", proveedor.getIdProveedor()));
        iProveedor.save(proveedorBuscado);
    }

    @Override
    public void deleteProveedorById(long idProveedor) {
        ProveedorModel proveedorBuscado = iProveedor.findById(idProveedor).orElseThrow(()->new ResourceNotFoundException("Proveedor","id",idProveedor));
        iProveedor.delete(proveedorBuscado);
    }

    private ProveedorDTO mapearDTOEntidad(ProveedorModel proveedorModel){
        ProveedorDTO proveedorDTO = modelMapper.map(proveedorModel,ProveedorDTO.class);
        return proveedorDTO;
    }

    private ProveedorModel mapearEntidadDTO(ProveedorDTO proveedorDTO){
        ProveedorModel proveedorModel = modelMapper.map(proveedorDTO,ProveedorModel.class);
        return proveedorModel;
    }
}
