package mx.veterinaria.chichen.itzamna.itzamna10.controller;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.PacientesDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.response.PacienteResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("chichen/itzamna/paciente")
public class PacienteController {

    @Autowired
    private IPacienteService sPaciente;

    @GetMapping
    public ResponseEntity<PacienteResponse> obtenerPacientes(
            @RequestParam(value = "numPage",defaultValue = "0") int numPage,
            @RequestParam (value = "numSize",defaultValue = "10") int numSize,
            @RequestParam (value = "orderBy",defaultValue = "idDiario") String orderBy,
            @RequestParam (value = "orderBy",defaultValue = "asc") String sortDir)
    {
        return new ResponseEntity<>(sPaciente.getAllPacientes(numPage,numSize,orderBy,sortDir), HttpStatus.OK);
    }

    @GetMapping("/propietario")
    public ResponseEntity<PacienteResponse> obtenerPacientesByPropietario(
            @RequestParam(value = "numPage",defaultValue = "0") int numPage,
            @RequestParam (value = "numSize",defaultValue = "10") int numSize,
            @RequestParam (value = "orderBy",defaultValue = "idDiario") String orderBy,
            @RequestParam (value = "orderBy",defaultValue = "asc") String sortDir,
            @RequestParam (value = "nombreProp") String nombreProp)
    {
        return new ResponseEntity<>(sPaciente.getAllPacienteByPropietario(numPage,numSize,orderBy,sortDir,nombreProp),HttpStatus.OK);
    }

    @GetMapping("/nombre")
    public ResponseEntity<PacienteResponse> obtenerPacientesByNombre(
            @RequestParam(value = "numPage",defaultValue = "0") int numPage,
            @RequestParam (value = "numSize",defaultValue = "10") int numSize,
            @RequestParam (value = "orderBy",defaultValue = "idDiario") String orderBy,
            @RequestParam (value = "orderBy",defaultValue = "asc") String sortDir,
            @RequestParam (value = "nombre",defaultValue = "" ) String nombre)
    {
        return new ResponseEntity<>(sPaciente.getPacienteByNombre(numPage,numSize,orderBy,sortDir,nombre),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacientesDTO> obtenerPacienteById(@PathVariable Long idPaciente){
        return new ResponseEntity<>(sPaciente.getPacienteById(idPaciente),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PacientesDTO> guardarPaciente(@RequestBody PacientesDTO pacientesDTO){
        return new ResponseEntity<>(sPaciente.savePaciente(pacientesDTO),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> actualizarPaciente(@RequestBody PacientesDTO pacientesDTO){
        sPaciente.updatePaciente(pacientesDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarPaciente(@PathVariable Long idPaciente){
        sPaciente.deletePacienteById(idPaciente);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
