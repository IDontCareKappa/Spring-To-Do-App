package pl.tostrowski.todolist.service;

import org.springframework.stereotype.Service;
import pl.tostrowski.todolist.model.ToDoItem;

import java.util.List;

public interface ToDoService {

    public List<ToDoItem> getItems();

    public ToDoItem getItem(Long id);

    public ToDoItem addItem(ToDoItem toDoItem);

    public void deleteItem(Long id);

    public ToDoItem putItem(Long id, ToDoItem toDoItem);

    public ToDoItem patchItem(Long id, ToDoItem toDoItem);

    public void markAsDone(Long id);

}
