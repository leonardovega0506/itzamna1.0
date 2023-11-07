package mx.veterinaria.chichen.itzamna.itzamna10.controller;


import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ServiciosDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ServiciosPacientesDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ServiciosPacientesResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IServiciosPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("chichen/itzamna/servicio_paciente")
public class ServicioPacienteController {

    @Autowired
    private IServiciosPacienteService sServicioP;

    @GetMapping
    public ResponseEntity<ServiciosPacientesResponse> obtenerServiciosPacientes(
            @RequestParam(value = "numPage",defaultValue = "0") int numPage,
            @RequestParam (value = "numSize",defaultValue = "10") int numSize,
            @RequestParam (value = "orderBy",defaultValue = "idDiario") String orderBy,
            @RequestParam (value = "orderBy",defaultValue = "asc") String sortDir
    )
    {
        return new ResponseEntity<>(sServicioP.getAllServiciosP(numPage,numSize,orderBy,sortDir), HttpStatus.OK);
    }

    @GetMapping("/paciente")
    public ResponseEntity<ServiciosPacientesResponse> obtenerServiciosPacientesByIsPaciente(
            @RequestParam(value = "numPage",defaultValue = "0") int numPage,
            @RequestParam (value = "numSize",defaultValue = "10") int numSize,
            @RequestParam (value = "orderBy",defaultValue = "idDiario") String orderBy,
            @RequestParam (value = "orderBy",defaultValue = "asc") String sortDir,
            @RequestParam (value = "idPaciente") Long idPaciente
    )
    {
        return new ResponseEntity<>(sServicioP.getAllServiciosByPaciente(numPage,numSize,orderBy,sortDir,idPaciente),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiciosPacientesDTO> obtenerServiciosPById(@PathVariable Long idServicio){
        return new ResponseEntity<>(sServicioP.getPacienteById(idServicio),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ServiciosPacientesDTO> guardarServicioPaciente(@RequestBody ServiciosPacientesDTO serviciosDTO){
        return new ResponseEntity<>(sServicioP.saveServicioPacinte(serviciosDTO),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> actualizarServicioP(@RequestBody ServiciosPacientesDTO serviciosPacientesDTO){
        sServicioP.updateServiciosPacientes(serviciosPacientesDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarServicioP(@PathVariable Long idServicioP){
        sServicioP.deleteServiciosPaciente(idServicioP);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
