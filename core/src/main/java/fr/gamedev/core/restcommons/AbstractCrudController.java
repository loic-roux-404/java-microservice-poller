package fr.gamedev.core.restcommons;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

public abstract class AbstractCrudController<T extends IdentifiedEntity> {

    private final AbstractCrudService<T> crudService;

    public AbstractCrudController(AbstractCrudService<T> crudService) {
        this.crudService = crudService;
    }

    @GetMapping
    public List<T> getClients() {
        return crudService.findAll();
    }

    @GetMapping("/{id}")
    public T getClient(@PathVariable Long id) throws RuntimeException {
        return crudService.find(id);
    }

    @PostMapping
    public ResponseEntity<T> createClient(@RequestBody T client) throws URISyntaxException {
        return crudService.create(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> updateClient(@PathVariable Long id, @RequestBody T client) {
        return crudService.update(id, client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<T> deleteClient(@PathVariable Long id) {
        return crudService.delete(id);
    }

}
