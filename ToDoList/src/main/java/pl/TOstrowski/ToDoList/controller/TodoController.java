package pl.tostrowski.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.tostrowski.todolist.model.ToDoItem;
import pl.tostrowski.todolist.service.ToDoService;

import javax.validation.Valid;

@RequestMapping("/todo")
@Controller
public class ToDoController {

    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping()
    public String findAll(Model model){
        model.addAttribute("items", toDoService.getItems());
        return "home";
    }

    @GetMapping("/{id}")
    public String findById(Model model, @PathVariable Long id){
        model.addAttribute("item", toDoService.getItem(id));
        return "todoitem";
    }

    @GetMapping("/add")
    public String addItem(Model model){
        ToDoItem toDoItem = new ToDoItem();
        model.addAttribute("toDoItem", toDoItem);
        return "additem";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute ToDoItem todoItem){
        toDoService.addItem(todoItem);
        return "redirect:/todo";
    }

    @GetMapping("/mark/{id}")
    public String markAsDone(@PathVariable Long id, @ModelAttribute ToDoItem toDoItem){
        toDoService.markAsDone(id);
        return "redirect:/todo";
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable Long id){
        toDoService.deleteItem(id);
        return "redirect:/todo";
    }

    @PutMapping("/{id}")
    public ToDoItem updateItem(@PathVariable Long id, @RequestBody @Valid ToDoItem toDoItem){
        return toDoService.putItem(id, toDoItem);
    }

    @PatchMapping("/{id}")
    public ToDoItem patchItem(@PathVariable Long id, @RequestBody @Valid ToDoItem toDoItem) {
        return toDoService.patchItem(id, toDoItem);
    }

}
