package com.practicaRecuperatorio.lastChance.Entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class TarifaDto {
    private final Long id;
    private final Long tipoTarifa;
    private final String definicion;
    private final Integer diaSemana;
    private final Integer diaMes;
    private final Integer mes;
    private final Integer anio;
    private final Float montoFijoAlquiler;
    private final Float montoMinutoFraccion;
    private final Float montoKm;
    private final Float montoHora;
}
