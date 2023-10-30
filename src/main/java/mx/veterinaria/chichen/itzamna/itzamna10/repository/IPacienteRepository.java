package mx.veterinaria.chichen.itzamna.itzamna10.repository;

import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.PacientesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPacienteRepository extends JpaRepository<PacientesModel,Long> {
    List<PacientesModel> findByPropietario_IdPropietario(Long idPropietario);
}
