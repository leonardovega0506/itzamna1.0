package mx.veterinaria.chichen.itzamna.itzamna10.repository;

import mx.veterinaria.chichen.itzamna.itzamna10.model.ServiciosModel;
import mx.veterinaria.chichen.itzamna.itzamna10.model.ServiciosPacientesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IServiciosPacientesRepository extends JpaRepository<ServiciosPacientesModel, Long> {
    List<ServiciosPacientesModel> findByPaciente_IdPaciente(Long idPaciente);
}
