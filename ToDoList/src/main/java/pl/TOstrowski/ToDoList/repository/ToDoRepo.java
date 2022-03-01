package pl.tostrowski.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tostrowski.todolist.model.ToDoItem;

public interface ToDoRepo extends JpaRepository<ToDoItem, Long> {
}
