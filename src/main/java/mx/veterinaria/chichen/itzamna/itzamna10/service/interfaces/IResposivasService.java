package mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces;

import mx.veterinaria.chichen.itzamna.itzamna10.model.ResponsivasModel;

import java.util.List;
import java.util.Optional;

public interface IResposivasService {

    List<ResponsivasModel> findAllResposivas();

    List<ResponsivasModel> findAllResponsivasByPaciente(Long idPaciente);

    Optional<ResponsivasModel> findResposivaById(Long idResposiva);

    ResponsivasModel saveResponsiva(ResponsivasModel responsiva);

    void deleteResposivaById(Long idResponsiva);
}
