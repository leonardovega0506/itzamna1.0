package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import mx.veterinaria.chichen.itzamna.itzamna10.model.dto.ResponsivasDTO;
import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ResponsivasModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IResposivaRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.response.ResponsivasResponse;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IResposivasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsivasServiceimpl implements IResposivasService {


    @Override
    public ResponsivasResponse getAllResponsivas(int numPage, int sizePage, String orderBy, String sortDir) {
        return null;
    }

    @Override
    public ResponsivasResponse getAllResponsivasByPaciente(int numPage, int sizePage, String orderBy, String sortDir, int idPaciente) {
        return null;
    }

    @Override
    public ResponsivasDTO getResponsivaById(Long idResponsiva) {
        return null;
    }

    @Override
    public ResponsivasDTO saveResponsiva(ResponsivasDTO responsiva) {
        return null;
    }

    @Override
    public void deleteResposivaById(Long idResponsiva) {

    }
}
