package com.practicaRecuperatorio.lastChance.Services;

import com.practicaRecuperatorio.lastChance.Entities.Tarifa;
import com.practicaRecuperatorio.lastChance.Entities.dto.TarifaDto;

import java.util.List;

public interface TarifaService extends Service <TarifaDto,Long> {
    List<TarifaDto> findByTipoTarifa(long tipoTarifa);
}
