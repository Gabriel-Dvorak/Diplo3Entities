package at.spengergasse.diplo3entities.controller;

import at.spengergasse.diplo3entities.persistance.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Inversion of Control
// Dependency Injection

// Get api todo -> return all todos

// Spring mvc
@RestController
@RequestMapping("api/todos")
// Lombok
@RequiredArgsConstructor // Großartig -> Ich kann vor TodoRepository schreiben
public class TodoController {
    // Dependency Injection (DI)
    private final TodoRepository todoRepository;
//    public TodoController(TodoRepository todoRepository) {
//        this.todoRepository = todoRepository;
//    }

    @GetMapping()
    public void getTodos() {
        var todos = todoRepository.findAll();
    }

    @GetMapping("/api/todos/{id}")
    public void getTodo(@PathVariable int id) {

    }
}