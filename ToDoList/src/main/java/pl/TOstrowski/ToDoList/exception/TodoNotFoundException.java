package pl.TOstrowski.ToDoList.exception;

public class TodoNotFoundException extends RuntimeException{

    public TodoNotFoundException(long id) {
        super("Could not find to do item: " + id);
    }
}
