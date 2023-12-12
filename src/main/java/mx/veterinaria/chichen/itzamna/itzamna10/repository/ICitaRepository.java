package mx.veterinaria.chichen.itzamna.itzamna10.repository;

import mx.veterinaria.chichen.itzamna.itzamna10.model.entity.CitasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ICitaRepository extends JpaRepository<CitasModel,Long> {
    List<CitasModel> findByFechaCita(LocalDate fechaCita);
    List<CitasModel> findByFechaCitaBetween(LocalDate fechaCitaStart, LocalDate fechaCitaEnd);

}
