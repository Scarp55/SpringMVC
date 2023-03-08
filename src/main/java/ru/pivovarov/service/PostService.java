package ru.pivovarov.service;

import org.springframework.stereotype.Service;
import ru.pivovarov.exception.NotFoundException;
import ru.pivovarov.model.Post;
import ru.pivovarov.repository.PostRepository;

import java.util.Collection;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Collection<Post> all() {
        return repository.all();
    }

    public Post getById(long id) {
        return repository.getById(id).orElseThrow(NotFoundException::new);
    }

    public Post save(Post post) {
        return repository.save(post);
    }

    public void removeById(long id) {
        repository.removeById(id);
    }
}
