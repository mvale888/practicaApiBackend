package com.practicaRecuperatorio.lastChance.Controllers;

import com.practicaRecuperatorio.lastChance.Entities.Tarifa;
import com.practicaRecuperatorio.lastChance.Entities.dto.TarifaDto;
import com.practicaRecuperatorio.lastChance.Repositories.TarifaRepository;
import com.practicaRecuperatorio.lastChance.Services.TarifaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tarifa")
public class TarifaController {

    private final TarifaService svc;
    private final TarifaRepository tarifaRepository;

    public TarifaController (TarifaService servicio, TarifaRepository tarifaRepository)
    {this.svc=servicio;
    this.tarifaRepository=tarifaRepository;}

    //Endpoint para obtener todas las Tarifas existentes.
    @GetMapping
    public  ResponseEntity<List<TarifaDto>> getAll(){
        List<TarifaDto> tarifas= svc.getAll();
        if(!tarifas.isEmpty()){
            return ResponseEntity.ok(tarifas);
        } else
            return ResponseEntity.noContent().build();
    }
    //Endpoint para agregar una nueva Tarifa
    @PostMapping
    public ResponseEntity<Void> add(@RequestBody TarifaDto entity) {
        svc.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //Endpoint para actualizar una Tarifa existente
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody TarifaDto entity) {
        svc.update(entity);
        return ResponseEntity.status(HttpStatus.OK).build(); // HttpStatus.OK devuelve un código HTTP://200
    }

    //Enpoint para buscar una Tarifa por id.
   // @GetMapping("/{id}")
   // public ResponseEntity<TarifaDto> getById(@PathVariable ("id") long id) {
    //    TarifaDto tarifaDto= svc.getById(id);
     //   if(tarifaDto!=null){
            // la clase ResponseEntity.ok de Spring Framework construye y devuelve una respuesta HTTP 200
     //       return ResponseEntity.ok(tarifaDto);
     //   } else
           //la clase ResponseEntity.notFound() construye y devuelve una respuesta HTTP 404 (Not Found)
    //        return ResponseEntity.notFound().build();
  // }

    //Endpoint para buscar por Tipo de Tarifa
    @GetMapping("/{id}")
    public ResponseEntity<List<TarifaDto>>getByTipo(@PathVariable ("id")long tipo){
        List<TarifaDto> values=svc.findByTipoTarifa(tipo);
        if(!values.isEmpty()) {
            return ResponseEntity.ok(values);
        } else
            return ResponseEntity.notFound().build();
    }


    //Enpoint para borrar una Tarifa existente.
    @DeleteMapping ("/{id}")
    public ResponseEntity <TarifaDto> delete(@PathVariable ("id") Long id) {
        TarifaDto tarifaDto= svc.delete(id);
        if(tarifaDto!=null){
            return ResponseEntity.ok(tarifaDto);
        }
        else
            return ResponseEntity.notFound().build();
    }
   }
