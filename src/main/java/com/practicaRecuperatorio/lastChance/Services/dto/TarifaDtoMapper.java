package com.practicaRecuperatorio.lastChance.Services.dto;

import com.practicaRecuperatorio.lastChance.Entities.Tarifa;
import com.practicaRecuperatorio.lastChance.Entities.dto.TarifaDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class TarifaDtoMapper implements Function<Tarifa, TarifaDto> {
                    //Recibe una Entity y la salida es un tipo Dto.
    @Override
    public TarifaDto apply(Tarifa tarifa) {
        return new TarifaDto(
                tarifa.getId(),
                tarifa.getTipoTarifa(),
                tarifa.getDefinicion(),
                tarifa.getDiaSemana(),
                tarifa.getDiaMes(),
                tarifa.getMes(),
                tarifa.getAnio(),
                tarifa.getMontoFijoAlquiler(),
                tarifa.getMontoMinutoFraccion(),
                tarifa.getMontoKm(),
                tarifa.getMontoHora());
    }
}
