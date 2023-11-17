package mx.veterinaria.chichen.itzamna.itzamna10.controller;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.VentasDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.response.VentasResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("chichen/itzamna/venta")
public class VentaController {

    @Autowired
    private IVentaService sVenta;

    @GetMapping
    public ResponseEntity<VentasResponse> obtenerVentas(
            @RequestParam(value = "numPage",defaultValue = "0") int numPage,
            @RequestParam (value = "numSize",defaultValue = "10") int numSize,
            @RequestParam (value = "orderBy",defaultValue = "idVenta") String orderBy,
            @RequestParam (value = "sortDir",defaultValue = "asc") String sortDir
    )
    {
        return new ResponseEntity<>(sVenta.getAllVenta(numPage,numSize,orderBy,sortDir), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentasDTO> obtenerVentaById(@PathVariable(value = "id") Long idVenta){
        return new ResponseEntity<>(sVenta.getVentaById(idVenta),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VentasDTO> guardarVenta(@RequestBody VentasDTO ventasDTO){
        return new ResponseEntity<>(sVenta.saveVenta(ventasDTO),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> actualizarVenta(@RequestBody VentasDTO ventasDTO){
        sVenta.updateVenta(ventasDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarVenta(@PathVariable Long idVenta){
        sVenta.deleteVentaById(idVenta);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
