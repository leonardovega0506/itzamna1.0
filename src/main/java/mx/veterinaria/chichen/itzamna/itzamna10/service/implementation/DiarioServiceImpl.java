package mx.veterinaria.chichen.itzamna.itzamna10.service.implementation;

import mx.veterinaria.chichen.itzamna.itzamna10.model.DiarioModel;
import mx.veterinaria.chichen.itzamna.itzamna10.repository.IDiarioRepository;
import mx.veterinaria.chichen.itzamna.itzamna10.service.interfaces.IDiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DiarioServiceImpl implements IDiarioService {

    @Autowired
    private IDiarioRepository iDiario;

    @Override
    public List<DiarioModel> findAllDiairios() {
        return iDiario.findAll();
    }

    @Override
    public List<DiarioModel> findAllDiariosByFecha(LocalDate fecha) {
        return iDiario.findByFechaDiario(fecha);
    }

    @Override
    public Optional<DiarioModel> findDiairioById(Long idDiairio) {
        return iDiario.findById(idDiairio);
    }

    @Override
    public DiarioModel saveDiairio(DiarioModel diario) {
        return iDiario.save(diario);
    }

    @Override
    public void updateDiairio(DiarioModel diairio) {
        iDiario.save(diairio);
    }

    @Override
    public void deleteDiarioById(Long idDiairio) {
        iDiario.deleteById(idDiairio);
    }
}
