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
            @RequestParam (value = "orderBy",defaultValue = "idProducto") String orderBy,
            @RequestParam (value = "sortDir",defaultValue = "asc") String sortDir
    )
    {
        return new ResponseEntity<>(sProducto.getAllProductos(numPage,numSize,orderBy,sortDir), HttpStatus.OK);
    }

    @GetMapping("/proveedor")
    public ResponseEntity<ProductoResponse> obtenerProductosByProveedor(
            @RequestParam(value = "numPage",defaultValue = "0") int numPage,
            @RequestParam (value = "numSize",defaultValue = "10") int numSize,
            @RequestParam (value = "orderBy",defaultValue = "idProducto") String orderBy,
            @RequestParam (value = "sortDir",defaultValue = "asc") String sortDir,
            @RequestParam (value="idProveedor") Long idProveedor
    )
    {
        return new ResponseEntity<>(sProducto.getAllProductoByProveedor(numPage,numSize,orderBy,sortDir,idProveedor),HttpStatus.OK);
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
    public ResponseEntity<ProductosDTO> obtenerProductoById(@PathVariable (value = "id") Long idProducto){
        return new ResponseEntity<>(sProducto.getProductoById(idProducto),HttpStatus.OK);
    }

    @GetMapping("/clave")
    public ResponseEntity<ProductosDTO> obtenerProductoByClave(@RequestParam (value = "clave") String claveProducto){
        return new ResponseEntity<>(sProducto.getProductoByClaveProducto(claveProducto),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductosDTO> guardarProducto(@RequestBody ProductosDTO productosDTO,@RequestParam Long idProveedor){
        return new ResponseEntity<>(sProducto.saveProducto(productosDTO,idProveedor),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> actualizarProducto(@RequestBody ProductosDTO productosDTO){
        sProducto.updateProductos(productosDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<HttpStatus> eliminarProducto(@PathVariable Long idProducto){
        sProducto.deleteProdycById(idProducto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
