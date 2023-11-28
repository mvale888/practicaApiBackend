package com.practicaRecuperatorio.lastChance.Controllers;

import com.practicaRecuperatorio.lastChance.Entities.dto.TarifaDto;
import com.practicaRecuperatorio.lastChance.Services.TarifaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tarifa")
public class TarifaController {

    private final TarifaService svc;

    public TarifaController (TarifaService servicio){this.svc=servicio;}

    //Endpoint para agregar una nueva Tarifa
    @PostMapping
    public ResponseEntity<Void> add(@RequestBody TarifaDto entity) {
        svc.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //Enpoint para buscar por una Tarifa por id
    @GetMapping("/{id}")
    public ResponseEntity<TarifaDto> getById(@PathVariable ("id") long id) {
        TarifaDto tarifaDto= svc.getById(id);
        if(tarifaDto!=null){
            // la clase ResponseEntity.ok de Spring Framework construye y devuelve una respuesta HTTP 200
            return ResponseEntity.ok(tarifaDto);
        } else
            //la clase ResponseEntity.notFound() construye y devuelve una respuesta HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
    }



    public List<TarifaDto> getAll() {
        return svc.getAll();
    }

    public TarifaDto delete(Long id) {
        return svc.delete(id);
    }

    public void update(TarifaDto entity) {
        svc.update(entity);
    }
}
