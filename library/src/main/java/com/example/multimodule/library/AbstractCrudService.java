package com.example.multimodule.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class AbstractCrudService<T extends IdentifiedEntity> {
    protected final PagingAndSortingRepository<T, Long> repo;

    protected final String uri;

    public AbstractCrudService(
            @Autowired PagingAndSortingRepository<T, Long> repo,
            String uri
    ) {
        this.repo = repo;
        this.uri = uri;
    }

    public List<T> findAll() {
        return StreamSupport.stream(repo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public T find(Long id) {
        return repo.findById(id).orElseThrow(RuntimeException::new);
    }

    public ResponseEntity<T> create(T data) throws URISyntaxException {
        T savedClient = repo.save(data);
        return ResponseEntity.created(
                new URI(String.format("/%s/%s", uri, savedClient.getId()))
        ).body(savedClient);
    }

    public ResponseEntity<T> update(Long id, @RequestBody T data) {
        data.setId(id);
        final T currentClient = repo.save(data);

        return ResponseEntity.ok(currentClient);
    }

    public ResponseEntity<Boolean> delete(Long id) {
        repo.deleteById(id);
        return ResponseEntity.ok(true);
    }

    public ResponseEntity<Boolean> exists(long id) {
        return ResponseEntity.ok(repo.existsById(id));
    }
}
