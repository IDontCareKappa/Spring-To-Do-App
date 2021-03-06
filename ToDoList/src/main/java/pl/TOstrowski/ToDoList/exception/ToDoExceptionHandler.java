package pl.tostrowski.todolist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ToDoExceptionHandler {

    public ResponseEntity<ErrorInfo> handleException(ToDoException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorInfo(e.getToDoError().getMessage()));
    }

}
