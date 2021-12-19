package pl.TOstrowski.ToDoList.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.TOstrowski.ToDoList.exception.TodoNotFoundException;
import pl.TOstrowski.ToDoList.model.TodoItem;
import pl.TOstrowski.ToDoList.repo.TodoRepo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoRepo todoRepo;

    @GetMapping("/todo")
    public List<TodoItem> findAll(){
        return todoRepo.findAll();
    }

    @PostMapping("/todo")
    public TodoItem save(@Valid @NotNull @RequestBody TodoItem todoItem){
        Optional<TodoItem> byId = todoRepo.findById(todoItem.getId());
        if(byId.isEmpty()){
            return todoRepo.save(todoItem);
        } else {
            throw new TodoNotFoundException(todoItem.getId());
        }

    }

    @PutMapping("/todo")
    public TodoItem update(@Valid @NotNull @RequestBody TodoItem todoItem){
        TodoItem byId = todoRepo.findById(todoItem.getId()).orElseThrow(
                () -> new TodoNotFoundException(todoItem.getId()) );
        return todoRepo.save(todoItem);

    }

    @DeleteMapping("/todo/{id}")
    public void delete(@PathVariable Long id){
        TodoItem byId = todoRepo.findById(id).orElseThrow(
                () -> new TodoNotFoundException(id)
        );
        todoRepo.deleteById(id);
    }

}
