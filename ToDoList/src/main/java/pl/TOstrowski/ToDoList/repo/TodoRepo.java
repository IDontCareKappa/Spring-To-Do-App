package pl.TOstrowski.ToDoList.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.TOstrowski.ToDoList.model.TodoItem;

public interface TodoRepo extends JpaRepository<TodoItem, Long> {


}
