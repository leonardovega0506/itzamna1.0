package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import mx.veterinaria.chichen.itzamna.itzamna10.model.ResponsivasModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IResposivaRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IResposivasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsivasServiceimpl implements IResposivasService {

    @Autowired
    private IResposivaRepository iResponsiva;

    @Override
    public List<ResponsivasModel> findAllResposivas() {
        return iResponsiva.findAll();
    }

    @Override
    public List<ResponsivasModel> findAllResponsivasByPaciente(Long idPaciente) {
        return iResponsiva.findByPaciente_IdPaciente(idPaciente);
    }

    @Override
    public Optional<ResponsivasModel> findResposivaById(Long idResposiva) {
        return iResponsiva.findById(idResposiva);
    }

    @Override
    public ResponsivasModel saveResponsiva(ResponsivasModel responsiva) {
        return iResponsiva.save(responsiva);
    }

    @Override
    public void deleteResposivaById(Long idResponsiva) {
        iResponsiva.deleteById(idResponsiva);
    }
}
