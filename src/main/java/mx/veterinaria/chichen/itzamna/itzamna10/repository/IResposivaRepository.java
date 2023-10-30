package mx.veterinaria.chichen.itzamna.itzamna10.repository;

import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ResponsivasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IResposivaRepository extends JpaRepository<ResponsivasModel,Long> {
    List<ResponsivasModel> findByPaciente_IdPaciente(Long idPaciente);
}
