package mx.veterinaria.chichen.itzamna.itzamna10.repository;

import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.ServiciosPacientesModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface IServiciosPacientesRepository extends JpaRepository<ServiciosPacientesModel, Long> {
    Page<ServiciosPacientesModel> findByPaciente_IdPaciente(Long idPaciente, Pageable pageable);
}
