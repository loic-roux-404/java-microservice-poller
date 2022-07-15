package com.example.multimodule.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

public abstract class AbstractCrudController<T extends IdentifiedEntity> {

    protected final AbstractCrudService<T> crudService;

    public AbstractCrudController(AbstractCrudService<T> crudService) {
        this.crudService = crudService;
    }

    @GetMapping
    public List<T> getAll() {
        return crudService.findAll();
    }

    @GetMapping("/{id}")
    public T get(@PathVariable Long id) throws RuntimeException {
        return crudService.find(id);
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T data) throws URISyntaxException {
        return crudService.create(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable Long id, @RequestBody T data) {
        return crudService.update(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<T> delete(@PathVariable Long id) {
        return crudService.delete(id);
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> exists(@PathVariable Long id) {
        return crudService.exists(id);
    }

}
