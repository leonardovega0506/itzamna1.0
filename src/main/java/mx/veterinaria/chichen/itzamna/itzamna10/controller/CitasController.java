package mx.veterinaria.chichen.itzamna.itzamna10.controller;


import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.CitasDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.response.CitasResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("chichen/itzamna/citas")
@CrossOrigin("*")
public class CitasController {

    @Autowired
    private ICitaService sCita;

    @GetMapping()
    public ResponseEntity<CitasResponse> obtenerCitas
            (@RequestParam(value = "numPage",defaultValue = "0") int numPage,
             @RequestParam (value = "numSize",defaultValue = "10") int numSize,
             @RequestParam (value = "orderBy",defaultValue = "idCita") String orderBy,
             @RequestParam (value = "sortDir",defaultValue = "asc") String sortDir){
        return new ResponseEntity<>(sCita.getAllCitas(numPage,numSize,orderBy,sortDir), HttpStatus.OK);
    }

    @GetMapping("/mes")
    public ResponseEntity<List<CitasDTO>>obtenerCitasByMes(@RequestParam String mes){
        LocalDate localDate = LocalDate.parse(mes);
        return new ResponseEntity<>(sCita.getCitasByMonth(localDate),HttpStatus.OK);
    }

    @GetMapping("/dia")
    public ResponseEntity<List<CitasDTO>> obtenerCitasByDia(@RequestParam String day){
        LocalDate localDate = LocalDate.parse(day);
        return new ResponseEntity<>(sCita.getCitasByDay(localDate),HttpStatus.OK);
    }

    @GetMapping("(/{idCita}")
    public ResponseEntity<CitasDTO> obtenerCitaByID(@PathVariable Long idCita){
        return new ResponseEntity<>(sCita.getCitaById(idCita),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CitasDTO> guardarCita(@RequestBody CitasDTO citasDTO){
        return new ResponseEntity<>(sCita.saveCita(citasDTO),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> actualizarCita(@RequestBody CitasDTO citasDTO){
        sCita.updateCita(citasDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{idCita}")
    public ResponseEntity<HttpStatus> eliminarCita(@PathVariable  Long idCita){
        sCita.deleteCitaById(idCita);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
