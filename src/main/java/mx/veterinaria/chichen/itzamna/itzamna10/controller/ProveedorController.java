package mx.veterinaria.chichen.itzamna.itzamna10.controller;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ProveedorDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IProveedorRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ProveedorResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("chichen/itzamna/proveedor")
public class ProveedorController {

    @Autowired
    private IProveedorService sProveedor;

    @GetMapping
    public ResponseEntity<ProveedorResponse> obtenerProveedores(
            @RequestParam(value = "numPage",defaultValue = "0") int numPage,
            @RequestParam (value = "numSize",defaultValue = "10") int numSize,
            @RequestParam (value = "orderBy",defaultValue = "idDiario") String orderBy,
            @RequestParam (value = "orderBy",defaultValue = "asc") String sortDir
    )
    {
        return new ResponseEntity<>(sProveedor.getAllProveedor(numPage,numSize,orderBy,sortDir), HttpStatus.OK);
    }

    @GetMapping("/nombre")
    public ResponseEntity<ProveedorResponse> obtenerProveedoresByNombre(
            @RequestParam(value = "numPage",defaultValue = "0") int numPage,
            @RequestParam (value = "numSize",defaultValue = "10") int numSize,
            @RequestParam (value = "orderBy",defaultValue = "idDiario") String orderBy,
            @RequestParam (value = "orderBy",defaultValue = "asc") String sortDir,
            @RequestParam (value = "nombre", defaultValue = "") String nombreProv
    )
    {
        return new ResponseEntity<>(sProveedor.getAllProveedorByNombre(numPage,numSize,orderBy,sortDir,nombreProv),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorDTO> obtenerProveedorById(@PathVariable Long idProveedor){
        return new ResponseEntity<>(sProveedor.getProveedorById(idProveedor),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProveedorDTO> guardarProveedor(@RequestBody ProveedorDTO proveedorDTO){
        return new ResponseEntity<>(sProveedor.saveProveedor(proveedorDTO),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> actualizarProveedor(@RequestBody ProveedorDTO proveedorDTO){
        sProveedor.updateProveedor(proveedorDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarProveedor(@PathVariable Long idProveedor){
        sProveedor.deleteProveedorById(idProveedor);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
