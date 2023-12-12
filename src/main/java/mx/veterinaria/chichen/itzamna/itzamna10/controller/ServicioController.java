package mx.veterinaria.chichen.itzamna.itzamna10.controller;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ServiciosDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ServiciosResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IServiciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("chichen/itzamna/servicio")
public class ServicioController {

    @Autowired
    private IServiciosService sServicio;

    @GetMapping
    public ResponseEntity<ServiciosResponse> obtenerServicios(
            @RequestParam(value = "numPage",defaultValue = "0") int numPage,
            @RequestParam (value = "numSize",defaultValue = "10") int numSize,
            @RequestParam (value = "orderBy",defaultValue = "idServicio") String orderBy,
            @RequestParam (value = "sortDir",defaultValue = "asc") String sortDir
    ){
        return new ResponseEntity<>(sServicio.getAllServicios(numPage,numSize,orderBy,sortDir), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiciosDTO> obtenerServicioById(@PathVariable(value = "id") Long idServicio){
        return new ResponseEntity<>(sServicio.getServicioById(idServicio),HttpStatus.OK);
    }

    @GetMapping("/clave")
    public ResponseEntity<ServiciosDTO> obtenerServicipByClave(@RequestParam (value = "clave") String clave){
        return new ResponseEntity<>(sServicio.getServicioByClave(clave),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ServiciosDTO> guardarServicio(@RequestBody ServiciosDTO serviciosDTO){
        return new ResponseEntity<>(sServicio.saveServicios(serviciosDTO),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> actualizarServicio(@RequestBody ServiciosDTO serviciosDTO){
        sServicio.updateServicio(serviciosDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{idServicio}")
    public ResponseEntity<HttpStatus> eliminarServicio(@PathVariable Long idServicio){
        sServicio.deleteServicioById(idServicio);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
