package mx.veterinaria.chichen.itzamna.itzamna10.controller;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ProductosDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ProductoResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("chichen/itzamna/producto")
public class ProductoController {

    @Autowired
    private IProductosService sProducto;

    @GetMapping
    public ResponseEntity<ProductoResponse> obtenerProductos(
            @RequestParam(value = "numPage",defaultValue = "0") int numPage,
            @RequestParam (value = "numSize",defaultValue = "10") int numSize,
            @RequestParam (value = "orderBy",defaultValue = "idDiario") String orderBy,
            @RequestParam (value = "orderBy",defaultValue = "asc") String sortDir
    )
    {
        return new ResponseEntity<>(sProducto.getAllProductos(numPage,numSize,orderBy,sortDir), HttpStatus.OK);
    }

    @GetMapping("/proveedor")
    public ResponseEntity<ProductoResponse> obtenerProductosByProveedor(
            @RequestParam(value = "numPage",defaultValue = "0") int numPage,
            @RequestParam (value = "numSize",defaultValue = "10") int numSize,
            @RequestParam (value = "orderBy",defaultValue = "idDiario") String orderBy,
            @RequestParam (value = "orderBy",defaultValue = "asc") String sortDir,
            @RequestParam (value="nombreProv") String nombreProv
    )
    {
        return new ResponseEntity<>(sProducto.getAllProductoByProveedor(numPage,numSize,orderBy,sortDir,nombreProv),HttpStatus.OK);
    }

    @GetMapping("/nombre")
    public ResponseEntity<ProductoResponse> obtenerProductoByNombre(
            @RequestParam (value = "numPage",defaultValue = "0") int numPage,
            @RequestParam (value = "numSize",defaultValue = "10") int numSize,
            @RequestParam (value = "orderBy",defaultValue = "idDiario") String orderBy,
            @RequestParam (value = "orderBy",defaultValue = "asc") String sortDir,
            @RequestParam (value = "nombre",defaultValue = "") String nombre
    )
    {
        return new ResponseEntity<>(sProducto.getProductoByNombre(numPage,numSize,orderBy,sortDir,nombre),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductosDTO> obtenerProductoById(@PathVariable Long idProducto){
        return new ResponseEntity<>(sProducto.getProductoById(idProducto),HttpStatus.OK);
    }

    @GetMapping("/clave")
    public ResponseEntity<ProductosDTO> obtenerProductoByClave(@RequestParam (value = "clave") String claveProducto){
        return new ResponseEntity<>(sProducto.getProductoByClaveProducto(claveProducto),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductosDTO> guardarProducto(@RequestBody ProductosDTO productosDTO){
        return new ResponseEntity<>(sProducto.saveProducto(productosDTO),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> actualizarProducto(@RequestBody ProductosDTO productosDTO){
        sProducto.updateProductos(productosDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarProducto(@PathVariable Long idProducto){
        sProducto.deleteProdycById(idProducto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
