package mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.CitasDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.response.CitasResponse;

import java.time.LocalDate;
import java.util.List;

public interface ICitaService {

    List<CitasDTO> getCitasByMonth(LocalDate month);

    CitasResponse getAllCitas(int numPage, int sizePage, String orderBy, String sortDir);

    List<CitasDTO> getCitasByDay(LocalDate day);

    CitasDTO getCitaById(Long idCita);

    CitasDTO saveCita(CitasDTO citasDTO);

    void updateCita(CitasDTO citasDTO);

    void deleteCitaById(Long idCita);
}
