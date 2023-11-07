package mx.veterinaria.chichen.itzamna.itzamna10.controller;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.DiarioDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.response.DiarioResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IDiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin("*")
@RestController
@RequestMapping("chichen/itzmna/diario")
public class DiarioController {

    @Autowired
    private IDiarioService sDiario;

    @GetMapping
    public ResponseEntity<DiarioResponse> obtenerDiarios(
            @RequestParam(value = "numPage",defaultValue = "0") int numPage,
            @RequestParam (value = "numSize",defaultValue = "10") int numSize,
            @RequestParam (value = "orderBy",defaultValue = "idDiario") String orderBy,
            @RequestParam (value = "orderBy",defaultValue = "asc") String sortDir){
        return new ResponseEntity<>(sDiario.getAllDiario(numPage,numSize,orderBy,sortDir), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiarioDTO> obtenerDiarioById(@PathVariable Long idDiario){
        return new ResponseEntity<>(sDiario.getDiarioById(idDiario),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DiarioDTO> guardarDiario(@RequestBody DiarioDTO diarioDTO){
        return new ResponseEntity<>(sDiario.saveDiario(diarioDTO),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> actualizarDiario(@RequestBody DiarioDTO diarioDTO){
        sDiario.updateDiario(diarioDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> asignarDiarioHistorico(){
        sDiario.assignDiairioToHistorico(LocalDate.now());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarDiario(@PathVariable Long idDiario){
        sDiario.deleteDiarioById(idDiario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
