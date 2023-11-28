package com.practicaRecuperatorio.lastChance.Entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class TarifaDto {
    private final Long id;
    private final int tipoTarifa;
    private final String definicion;
    private final int diaSemana;
    private final int diaMes;
    private final int mes;
    private final int anio;
    private final float montoFijoAlquiler;
    private final float montoMinutoFraccion;
    private final float montoKm;
    private final float montoHora;
}
