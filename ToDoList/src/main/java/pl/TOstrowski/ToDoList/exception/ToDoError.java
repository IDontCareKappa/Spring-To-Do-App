package pl.tostrowski.todolist.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ToDoError {

    ITEM_NOT_FOUND("Item does not exist");

    private String message;

}
