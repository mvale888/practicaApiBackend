package com.practicaRecuperatorio.lastChance.Repositories;

import com.practicaRecuperatorio.lastChance.Entities.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TarifaRepository extends JpaRepository<Tarifa,Long> {

    List<Tarifa>findByTipoTarifa(long tipoTarifa);
}
