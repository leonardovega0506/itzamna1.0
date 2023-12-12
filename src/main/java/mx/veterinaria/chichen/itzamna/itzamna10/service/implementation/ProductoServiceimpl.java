package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import lombok.extern.slf4j.Slf4j;
import mx.veterinaria.chichen.itzamna.itzamna10.exception.ResourceNotFoundException;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.PacientesDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ProductosDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.PacientesModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ProductosModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ProveedorModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IProductoRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IProveedorRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.response.PacienteResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ProductoResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IProductosService;
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
public class ProductoServiceimpl implements IProductosService {


    @Autowired
    private IProductoRepository iProducto;

    @Autowired
    private IProveedorRepository iProveedor;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductoResponse getAllProductos(int numPage, int sizePage, String orderBy, String sortDir) {
        //Generamos la paginacion
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(orderBy).ascending() : Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(numPage, sizePage, sort);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL NUMERO DE PAGINA, {}", numPage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL TAMAÑO DE PAGINA, {}", sizePage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA ORGANZAZCION, {}", orderBy);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA FORMA, {}", sortDir);
        //Buscamos y mapeamos a nuestro DTO
        Page<ProductosModel> productos = iProducto.findAll(pageable);
        List<ProductosModel> listaProductos = productos.getContent();
        List<ProductosDTO> contenido = listaProductos
                .stream()
                .map(producto -> mapearDTOEntidad(producto))
                .collect(Collectors.toList());

        log.info("OBTENEMOS LA LISTA MAPEADA A DTO");
        //Agregamos el contenido a nuestro response
        ProductoResponse productoResponse = new ProductoResponse();
        productoResponse.setContent(contenido);
        productoResponse.setAllElements(productos.getTotalElements());
        productoResponse.setAllPage(productos.getTotalPages());
        productoResponse.setNumPage(productos.getNumber());
        productoResponse.setSizePage(productos.getSize());
        productoResponse.setLast(productos.isLast());
        log.info("SE REGRESA LA INFORMACION DEL RESPONSE");
        return productoResponse;
    }

    @Override
    public ProductoResponse getAllProductoByProveedor(int numPage, int sizePage, String orderBy, String sortDir, Long idProveedor) {
        //Generamos la paginacion
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(orderBy).ascending() : Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(numPage, sizePage, sort);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL NUMERO DE PAGINA, {}", numPage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL TAMAÑO DE PAGINA, {}", sizePage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA ORGANZAZCION, {}", orderBy);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA FORMA, {}", sortDir);
        //Buscamos y mapeamos a nuestro DTO
        Page<ProductosModel> productos = iProducto.findByProveedor_IdProveedor(idProveedor, pageable);
        List<ProductosModel> listaProductos = productos.getContent();
        List<ProductosDTO> contenido = listaProductos
                .stream()
                .map(producto -> mapearDTOEntidad(producto))
                .collect(Collectors.toList());

        log.info("OBTENEMOS LA LISTA MAPEADA A DTO");
        //Agregamos el contenido a nuestro response
        ProductoResponse productoResponse = new ProductoResponse();
        productoResponse.setContent(contenido);
        productoResponse.setAllElements(productos.getTotalElements());
        productoResponse.setAllPage(productos.getTotalPages());
        productoResponse.setNumPage(productos.getNumber());
        productoResponse.setSizePage(productos.getSize());
        productoResponse.setLast(productos.isLast());
        log.info("SE REGRESA LA INFORMACION DEL RESPONSE");
        return productoResponse;
    }

    @Override
    public ProductoResponse getProductoByNombre(int numPage, int sizePage, String orderBy, String sortDir, String nombreProducto) {
        //Generamos la paginacion
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(orderBy).ascending() : Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(numPage, sizePage, sort);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL NUMERO DE PAGINA, {}", numPage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE EL TAMAÑO DE PAGINA, {}", sizePage);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA ORGANZAZCION, {}", orderBy);
        log.info("SE EMPEZARA A BUSCAR EL MEDIANTE LA FORMA, {}", sortDir);
        //Buscamos y mapeamos a nuestro DTO
        Page<ProductosModel> productos = iProducto.findAll(pageable);
        List<ProductosModel> listaProductos = productos.getContent();
        List<ProductosDTO> contenido = listaProductos
                .stream().filter(producto -> producto.getNombreProducto().contains(nombreProducto))
                .map(producto -> mapearDTOEntidad(producto))
                .collect(Collectors.toList());

        log.info("OBTENEMOS LA LISTA MAPEADA A DTO");
        //Agregamos el contenido a nuestro response
        ProductoResponse productoResponse = new ProductoResponse();
        productoResponse.setContent(contenido);
        productoResponse.setAllElements(productos.getTotalElements());
        productoResponse.setAllPage(productos.getTotalPages());
        productoResponse.setNumPage(productos.getNumber());
        productoResponse.setSizePage(productos.getSize());
        productoResponse.setLast(productos.isLast());
        log.info("SE REGRESA LA INFORMACION DEL RESPONSE");
        return productoResponse;
    }

    @Override
    public ProductosDTO getProductoById(Long idProducto) {
        ProductosModel productoBuscado = iProducto.findById(idProducto).orElseThrow(() -> new ResourceNotFoundException("Producto", "id", idProducto));
        return mapearDTOEntidad(productoBuscado);
    }

    @Override
    public ProductosDTO getProductoByClaveProducto(String claveProducto) {
        ProductosModel productoBuscado = iProducto.findByClaveProductoAllIgnoreCase(claveProducto).orElseThrow(() -> new ResourceNotFoundException("Producto", "id", claveProducto));
        return mapearDTOEntidad(productoBuscado);
    }

    @Override
    public ProductosDTO saveProducto(ProductosDTO producto, Long idProveedor) {
        ProveedorModel proveedorBuscado = iProveedor.findById(idProveedor).orElseThrow(() -> new ResourceNotFoundException("Proveedor", "id", idProveedor));

        ProductosModel productoNuevo = mapearEntidadDTO(producto);
        productoNuevo.setProveedor(proveedorBuscado);
        iProducto.save(productoNuevo);
        return mapearDTOEntidad(productoNuevo);
    }

    @Override
    public void updateProductos(ProductosDTO producto) {
        iProducto.save(mapearEntidadDTO(producto));
    }

    @Override
    public void deleteProdycById(Long idProducto) {
        ProductosModel productoBuscado = iProducto.findById(idProducto).orElseThrow(() -> new ResourceNotFoundException("Producto", "id", idProducto));
        iProducto.delete(productoBuscado);
    }

    private ProductosDTO mapearDTOEntidad(ProductosModel productosModel) {
        ProductosDTO productosDTO = modelMapper.map(productosModel, ProductosDTO.class);
        return productosDTO;
    }

    private ProductosModel mapearEntidadDTO(ProductosDTO productosDTO) {
        ProductosModel productosModel = modelMapper.map(productosDTO, ProductosModel.class);
        return productosModel;
    }
}
