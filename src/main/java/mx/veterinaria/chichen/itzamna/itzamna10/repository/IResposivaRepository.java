package mx.veterinaria.chichen.itzamna.itzamna10.repository;

import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ResponsivasModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IResposivaRepository extends JpaRepository<ResponsivasModel,Long> {
    Page<ResponsivasModel> findByPaciente_IdPaciente(Long idPaciente, Pageable pageable);

}
