package mx.veterinaria.chichen.itzamna.itzamna10.controller;


import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ComprasDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.DetalleCompraDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ComprasResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("chichen/itzmna/compras")
public class ComprasController {

    @Autowired
    private IComprasService sCompras;

    //Controlador para ver todas las compras
    @GetMapping
    public ResponseEntity<ComprasResponse> obtenerCompras(
            @RequestParam (value = "numPage",defaultValue = "0") int numPage,
            @RequestParam (value = "numSize",defaultValue = "10") int numSize,
            @RequestParam (value = "orderBy",defaultValue = "idCompra") String orderBy,
            @RequestParam (value = "orderBy",defaultValue = "asc") String sortDir){
        return new ResponseEntity<>(sCompras.getAllCompras(numPage,numSize,orderBy,sortDir), HttpStatus.OK);
    }

    //Controlador para ver las compras por proveedor
    @GetMapping("/proveedor")
    public ResponseEntity<ComprasResponse> obtenerComprasByProveedor(
            @RequestParam (value = "numPage",defaultValue = "0") int numPage,
            @RequestParam (value = "numSize",defaultValue = "10") int numSize,
            @RequestParam (value = "orderBy",defaultValue = "idCompra") String orderBy,
            @RequestParam (value = "orderBy",defaultValue = "asc") String sortDir,
            @RequestParam (value = "idProveedor",defaultValue = "") Long idProveedor)
    {
         return new ResponseEntity<>(sCompras.getAllCompraseByProveedor(numPage,numSize,orderBy,sortDir,idProveedor),HttpStatus.OK);
    }

    //Controlador para ver la compra por id
    @GetMapping("/{id}")
    public ResponseEntity<ComprasDTO> obtenerCompraById(@PathVariable Long idCompra){
        return new ResponseEntity<>(sCompras.getCompraById(idCompra),HttpStatus.OK);
    }

    //Controlador para ver los detalles de la compra
    @GetMapping("/{id}/details")
    public ResponseEntity<List<DetalleCompraDTO>> obtenerDetallesCompras(Long idCompra){
        return new ResponseEntity<>(sCompras.getDetallesByCompra(idCompra),HttpStatus.OK);
    }

    //Controlador para ver la compra por nota
    @GetMapping("/nota")
    public ResponseEntity<ComprasDTO> obtenerCompraByNota(@RequestParam(value = "notaCompra") String notaCompra){
        return new ResponseEntity<>(sCompras.getcompraByNotaCompra(notaCompra),HttpStatus.OK);
    }

    //Controlador para guardar la compra
    @PostMapping
    public ResponseEntity<ComprasDTO> guardarCompra(@RequestBody ComprasDTO comprasDTO){
        return new ResponseEntity<>(sCompras.saveCompra(comprasDTO),HttpStatus.CREATED);
    }

    //Controlador para actualizar la compra
    @PutMapping
    public ResponseEntity<HttpStatus> actualizarCompra(@RequestBody ComprasDTO comprasDTO){
        sCompras.updateCompra(comprasDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Controlador para elimianr la compra
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarCompra(@PathVariable Long idCompra){
        sCompras.deleteCompraById(idCompra);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
