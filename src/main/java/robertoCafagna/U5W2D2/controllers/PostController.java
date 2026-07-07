package robertoCafagna.U5W2D2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import robertoCafagna.U5W2D2.entities.Post;
import robertoCafagna.U5W2D2.payloads.PostPayload;
import robertoCafagna.U5W2D2.services.PostService;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 1. GET http://localhost:3001/posts --> 200 OK    ARRAY DI POST
    @GetMapping
    public List<Post> findAll() {
        return this.postService.findAll();
    }

    //2. POST http://localhost:3001/posts (+payload) --> 201 CREATED     POST APPENA CREATO

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody PostPayload body) {
        return this.postService.save(body);
    }


    // 3. GET  http://localhost:3001/posts/{postId} --> 200 OK  POST TROVATO

    @GetMapping("/{postId}")
    public Post findById(@PathVariable long postId) {
        return this.postService.findById(postId);
    }

    // 4. PUT http://localhost:3001/posts/{postId} (+payload) --> 200 OK  POST AGGIORNATO
    @PutMapping("/{postId}")
    public Post findByIdAndUpdate(@PathVariable long postId, @RequestBody PostPayload body) {
        return this.postService.findByIdAndUpdate(postId, body);
    }

    //5.DELETE http://localhost:PORT/posts/{postId} --> 204 NO CONTENT
    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable long postId) {
        this.postService.findAndDelete(postId);
    }

}
