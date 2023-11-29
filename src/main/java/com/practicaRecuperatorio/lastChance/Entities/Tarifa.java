package com.practicaRecuperatorio.lastChance.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@Entity
@Table(name="tarifas")
@Data
@NoArgsConstructor (force = true)
@RequiredArgsConstructor
public class Tarifa {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private final Long id;

    @Column (name="tipo_tarifa")
    private final Long tipoTarifa;

    private final String definicion;

    @Column(name="dia_semana")
    private final Integer diaSemana;

    @Column(name="dia_mes")

    private final Integer diaMes;

    private final Integer mes;

    private final Integer anio;

    @Column(name="monto_fijo_alquiler")
    private final Float montoFijoAlquiler;

    @Column(name="monto_minuto_fraccion")
    private final Float montoMinutoFraccion;

    @Column(name="monto_km")
    private final Float montoKm;

    @Column(name="monto_hora")
    private final Float montoHora;
}
