import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@SpringBootApplication
public class PokemonApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(PokemonApiApplication.class, args);
    }
}

@RestController
@RequestMapping("/api/pokemon")
class PokemonController {

    private final Map<Integer, Pokemon> pokemonDatabase = new HashMap<>();
    private int currentId = 1;

    @GetMapping
    public List<Pokemon> getAllPokemon() {
        return new ArrayList<>(pokemonDatabase.values());
    }

    @GetMapping("/{id}")
    public Pokemon getPokemonById(@PathVariable int id) {
        if (!pokemonDatabase.containsKey(id)) {
            throw new PokemonNotFoundException("Pokemon with ID " + id + " not found.");
        }
        return pokemonDatabase.get(id);
    }

    @PostMapping
    public Pokemon addPokemon(@RequestBody Pokemon pokemon) {
        pokemon.setId(currentId++);
        pokemonDatabase.put(pokemon.getId(), pokemon);
        return pokemon;
    }

    @PutMapping("/{id}")
    public Pokemon updatePokemon(@PathVariable int id, @RequestBody Pokemon updatedPokemon) {
        if (!pokemonDatabase.containsKey(id)) {
            throw new PokemonNotFoundException("Pokemon with ID " + id + " not found.");
        }
        updatedPokemon.setId(id);
        pokemonDatabase.put(id, updatedPokemon);
        return updatedPokemon;
    }

    @DeleteMapping("/{id}")
    public void deletePokemon(@PathVariable int id) {
        if (!pokemonDatabase.containsKey(id)) {
            throw new PokemonNotFoundException("Pokemon with ID " + id + " not found.");
        }
        pokemonDatabase.remove(id);
    }

    @GetMapping("/search")
    public List<Pokemon> searchPokemon(@RequestParam(required = false) String name, @RequestParam(required = false) String type) {
        return pokemonDatabase.values().stream()
                .filter(p -> (name == null || p.getName().equalsIgnoreCase(name)) &&
                             (type == null || p.getType().equalsIgnoreCase(type)))
                .toList();
    }
}

@ResponseStatus(code = org.springframework.http.HttpStatus.NOT_FOUND)
class PokemonNotFoundException extends RuntimeException {
    public PokemonNotFoundException(String message) {
        super(message);
    }
}

class Pokemon {
    private int id;
    private String name;
    private String type;
    private int level;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
