package com.practicaRecuperatorio.lastChance.Services;

import com.practicaRecuperatorio.lastChance.Entities.Tarifa;
import com.practicaRecuperatorio.lastChance.Entities.dto.TarifaDto;
import com.practicaRecuperatorio.lastChance.Repositories.TarifaRepository;
import com.practicaRecuperatorio.lastChance.Services.dto.TarifaDtoMapper;
import com.practicaRecuperatorio.lastChance.Services.dto.TarifaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class TarifaServiceImpl implements TarifaService{

    private final TarifaRepository tarifaRepository;
    private final TarifaDtoMapper tarifaDtoMapper;
    private final TarifaMapper tarifaMapper;

    // Constructor de esta clase
    public TarifaServiceImpl(TarifaRepository tarifaRepository,TarifaDtoMapper tarifaDtoMapper,TarifaMapper tarifaMapper){
        this.tarifaRepository=tarifaRepository;
        this.tarifaDtoMapper=tarifaDtoMapper;
        this.tarifaMapper=tarifaMapper;
    }
    @Override
    public void add(TarifaDto entity) {
        //para manejar los posibles valores nulos de entity.
        //crea un objeto "Optional". Si existe entonces
        //crea un mapeo desde esa entity que es tipo "TarifaDto" hacia una entidad tipo "Tarifa".
        //Por último con el método .get() obtenemos el valor resultante del "Optional".
        Tarifa tarifa= Optional.of(entity).map(tarifaMapper).get();
        tarifaRepository.save(tarifa);
    }
    @Override
    public void update(TarifaDto entity) {
        Optional<Tarifa> optionalTarifa = Stream.of(entity).map(tarifaMapper).findFirst();
        optionalTarifa.ifPresent(tarifaRepository::save);
    }

    @Override
    public TarifaDto getById(Long id) {
        Tarifa tarifa= tarifaRepository.findById(id).orElse(null);
        //utiliza una expresión ternaria para realizar una comprobación de nulidad antes de mappear
        // Si tarifa no es nula, se aplica la función de mapeo tarifaDtoMapper
        return tarifa!= null? tarifaDtoMapper.apply(tarifa):null; // si tarifa es nula, devuelve null.
    }

    @Override
    public TarifaDto delete(Long id) {
        Optional<Tarifa> optionalTarifa = tarifaRepository.findById(id);
        if (optionalTarifa.isPresent()) {
            tarifaRepository.delete(optionalTarifa.get());
            return tarifaDtoMapper.apply(optionalTarifa.get());
        } else {
            return null;
        }
    }

    @Override
    public List<TarifaDto> getAll() {
        List<Tarifa> values= tarifaRepository.findAll();
        //Convierte la colección values en un flujo (stream) de elementos.
        //Luego aplica la función de mapeo tarifaDtoMapper a cada elemento del stream.
        // y el toList(), recolecta los elementos del stream y los devuelve como una lista.
        return values.stream().map(tarifaDtoMapper).toList();
    }
    @Override
    public List<TarifaDto> findByTipoTarifa(long tipoTarifa) {
        return tarifaRepository.findByTipoTarifa(tipoTarifa)
                .stream()
                .map(tarifaDtoMapper)
                .toList();
    }
    //Realiza una búsqueda en la base de datos de todas las tarifas con un determinado tipoTarifa.
    //Luego, utiliza un mapeo (tarifaDtoMapper) para convertir los resultados de las entidades Tarifa
    // en objetos de transferencia de datos (TarifaDto).

}
