package mx.veterinaria.chichen.itzamna.itzamna10.repository;

import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.DiarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IDiarioRepository extends JpaRepository<DiarioModel, Long> {
    List<DiarioModel> findByFechaDiario(LocalDate fechaDiario);
}
