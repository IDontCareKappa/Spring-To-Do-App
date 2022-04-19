package pl.tostrowski.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tostrowski.todolist.model.ToDoItem;

import java.util.List;

public interface ToDoRepo extends JpaRepository<ToDoItem, Long> {

    public List<ToDoItem> findAllByTitleNotNullOrderByPriorityDesc();

}
