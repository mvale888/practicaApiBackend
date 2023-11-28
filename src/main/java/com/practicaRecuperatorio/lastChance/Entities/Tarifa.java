package com.practicaRecuperatorio.lastChance.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="tarifas")
@Data
@NoArgsConstructor (force = true)
@AllArgsConstructor
public class Tarifa {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private final Long id;
    @Column (name="tipo_tarifa")
    private final int tipoTarifa;
    private final String definicion;
    @Column(name="dia_semana")
    private final int diaSemana;
    @Column(name="dia_mes")
    private final int diaMes;
    private final int mes;
    private final int anio;
    @Column(name="monto_fijo_alquiler")
    private final float montoFijoAlquiler;
    @Column(name="monto_minuto_fraccion")
    private final float montoMinutoFraccion;
    @Column(name="monto_km")
    private final float montoKm;
    @Column(name="monto_hora")
    private final float montoHora;

}
