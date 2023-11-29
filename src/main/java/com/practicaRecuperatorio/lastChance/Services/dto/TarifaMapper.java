package com.practicaRecuperatorio.lastChance.Services.dto;

import com.practicaRecuperatorio.lastChance.Entities.Tarifa;
import com.practicaRecuperatorio.lastChance.Entities.dto.TarifaDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TarifaMapper implements Function<TarifaDto, Tarifa> {
    //1° param. Lo que recibe a transformar, 2° param.La salida.
    //Aquí estamos mappeando de un DTo a una entity.
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
