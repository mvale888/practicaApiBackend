package com.practicaRecuperatorio.lastChance.Services.dto;

import com.practicaRecuperatorio.lastChance.Entities.Tarifa;
import com.practicaRecuperatorio.lastChance.Entities.dto.TarifaDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TarifaMapper implements Function<TarifaDto, Tarifa> {

    @Override
    public Tarifa apply(TarifaDto tarifaDto) {
        return new Tarifa(
                tarifaDto.getId(),
                tarifaDto.getTipoTarifa(),
                tarifaDto.getDefinicion(),
                tarifaDto.getDiaSemana(),
                tarifaDto.getDiaMes(),
                tarifaDto.getMes(),
                tarifaDto.getAnio(),
                tarifaDto.getMontoFijoAlquiler(),
                tarifaDto.getMontoMinutoFraccion(),
                tarifaDto.getMontoKm(),
                tarifaDto.getMontoHora());
    }
}
