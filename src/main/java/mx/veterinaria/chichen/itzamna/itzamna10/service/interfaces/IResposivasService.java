package mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ResponsivasDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ResponsivasModel;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ResponsivasResponse;

import java.util.List;
import java.util.Optional;

public interface IResposivasService {


    ResponsivasResponse getAllResponsivas(int numPage, int sizePage, String orderBy, String sortDir);
    ResponsivasResponse getAllResponsivasByPaciente(int numPage, int sizePage, String orderBy, String sortDir, int idPaciente);
    ResponsivasDTO getResponsivaById(Long idResponsiva);
    ResponsivasDTO saveResponsiva(ResponsivasDTO responsiva);
    void deleteResposivaById(Long idResponsiva);
}
