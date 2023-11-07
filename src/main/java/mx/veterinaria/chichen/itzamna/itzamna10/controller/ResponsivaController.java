package mx.veterinaria.chichen.itzamna.itzamna10.controller;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ResponsivasDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ResponsivasResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IResposivasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("chichen/itzamna/responsivas")
public class ResponsivaController {

    @Autowired
    private IResposivasService sResponsiva;

    @GetMapping
    public ResponseEntity<ResponsivasResponse> obtenerResponsivas(
            @RequestParam(value = "numPage",defaultValue = "0") int numPage,
            @RequestParam (value = "numSize",defaultValue = "10") int numSize,
            @RequestParam (value = "orderBy",defaultValue = "idDiario") String orderBy,
            @RequestParam (value = "orderBy",defaultValue = "asc") String sortDir
    )
    {
        return new ResponseEntity<>(sResponsiva.getAllResponsivas(numPage,numSize,orderBy,sortDir), HttpStatus.OK);
    }

    @GetMapping("/paciente")
    public ResponseEntity<ResponsivasResponse> obtenerResponsivasByPaciente(
            @RequestParam(value = "numPage",defaultValue = "0") int numPage,
            @RequestParam (value = "numSize",defaultValue = "10") int numSize,
            @RequestParam (value = "orderBy",defaultValue = "idDiario") String orderBy,
            @RequestParam (value = "orderBy",defaultValue = "asc") String sortDir,
            @RequestParam (value = "idPaciente") Long  idPaciente
    )
    {
        return new ResponseEntity<>(sResponsiva.getAllResponsivasByPaciente(numPage,numSize,orderBy,sortDir,idPaciente),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsivasDTO> obtenerResponsivaById(@PathVariable Long idResponsiva){
        return new ResponseEntity<>(sResponsiva.getResponsivaById(idResponsiva),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponsivasDTO> guardarResponsiva(@RequestBody ResponsivasDTO responsivasDTO){
        return new ResponseEntity<>(sResponsiva.saveResponsiva(responsivasDTO),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarResponsiva(@PathVariable Long idResponsiva){
        sResponsiva.deleteResposivaById(idResponsiva);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
