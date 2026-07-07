package robertoCafagna.U5W2D2.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import robertoCafagna.U5W2D2.entities.Post;
import robertoCafagna.U5W2D2.exception.NotFoundException;
import robertoCafagna.U5W2D2.payloads.PostPayload;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PostService {
    private List<Post> postDB = new ArrayList<>();

    public List<Post> findAll() {
        return this.postDB;
    }

    public Post save(PostPayload body) {
        Post newPost = new Post(body.getCategoria(), body.getTitolo(),
                body.getContenuto(), body.getMinutiDiLettura());
        this.postDB.add(newPost);
        log.info("L'utente:" + newPost.getId() + "è stato salvato");
        return newPost;
    }

    public Post findById(long postId) {
        Post found = null;

        for (Post post : this.postDB) {
            if (post.getId() == postId) found = post;
        }
        if (found == null) throw new NotFoundException("risorsa non trovata");

        return found;
    }

    public Post findByIdAndUpdate(long postId, PostPayload body) {
        Post found = findById(postId);
        found.setCategoria(body.getCategoria());
        found.setContenuto(body.getContenuto());
        found.setTitolo(body.getTitolo());
        found.setMinutiDiLettura(body.getMinutiDiLettura());

        return found;
    }

    public void findAndDelete(long postId) {
        Post found = findById(postId);
        this.postDB.remove(found);
    }

}
