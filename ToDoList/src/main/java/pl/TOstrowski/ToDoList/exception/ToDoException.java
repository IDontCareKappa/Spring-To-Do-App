package pl.tostrowski.todolist.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ToDoException extends  RuntimeException{

    private ToDoError toDoError;

}
