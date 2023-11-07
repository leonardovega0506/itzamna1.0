package mx.veterinaria.chichen.itzamna.itzamna10.controller;


import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.PropietarioDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.response.PropietarioResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IProductosService;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IPropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("chichen/itzmna/propietario")
@RestController
public class PropietarioController {

    @Autowired
    private IPropietarioService sPropietario;

    @GetMapping
    public ResponseEntity<PropietarioResponse> obtenerPropietarios(
            @RequestParam(value = "numPage",defaultValue = "0") int numPage,
            @RequestParam (value = "numSize",defaultValue = "10") int numSize,
            @RequestParam (value = "orderBy",defaultValue = "idDiario") String orderBy,
            @RequestParam (value = "orderBy",defaultValue = "asc") String sortDir
    )
    {
        return new ResponseEntity<>(sPropietario.getAllPropietarios(numPage,numSize,orderBy,sortDir), HttpStatus.OK);
    }

    @GetMapping("/nombre")
    public ResponseEntity<PropietarioResponse> obtenerPropietariosByNombre(
            @RequestParam(value = "numPage",defaultValue = "0") int numPage,
            @RequestParam (value = "numSize",defaultValue = "10") int numSize,
            @RequestParam (value = "orderBy",defaultValue = "idDiario") String orderBy,
            @RequestParam (value = "orderBy",defaultValue = "asc") String sortDir,
            @RequestParam (value = "nombre",defaultValue = "") String nombre
    )
    {
        return new ResponseEntity<>(sPropietario.getllPropietariosByNombre(numPage,numSize,orderBy,sortDir,nombre),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropietarioDTO> obtenerPropietarioById(@PathVariable Long idPropietario){
        return new ResponseEntity<>(sPropietario.getPropietarioById(idPropietario),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PropietarioDTO> guardarPropietario(@RequestBody PropietarioDTO propietarioDTO){
        return new ResponseEntity<>(sPropietario.savePropietario(propietarioDTO),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> actualizarPropietario(@RequestBody PropietarioDTO propietarioDTO) {
        sPropietario.updatePropietario(propietarioDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarPropietario(@PathVariable Long idPropietario){
        sPropietario.deleteByIdPropietario(idPropietario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
