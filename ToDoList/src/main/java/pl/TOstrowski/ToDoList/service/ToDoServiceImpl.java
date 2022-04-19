package pl.tostrowski.todolist.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pl.tostrowski.todolist.exception.ToDoError;
import pl.tostrowski.todolist.exception.ToDoException;
import pl.tostrowski.todolist.model.ToDoItem;
import pl.tostrowski.todolist.repository.ToDoRepo;

import java.util.Comparator;
import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepo toDoRepo;

    public ToDoServiceImpl(ToDoRepo toDoRepo) {
        this.toDoRepo = toDoRepo;
    }

    public List<ToDoItem> getItems() {
        return toDoRepo.findAllByTitleNotNullOrderByPriorityDesc();
    }

    public ToDoItem getItem(Long id) {
        return toDoRepo.findById(id)
                .orElseThrow(() -> new ToDoException(ToDoError.ITEM_NOT_FOUND));
    }

    public ToDoItem addItem(ToDoItem toDoItem) {
        return toDoRepo.save(toDoItem);
    }

    public void deleteItem(Long id) {
        ToDoItem toDoItem = toDoRepo.findById(id)
                .orElseThrow(() -> new ToDoException(ToDoError.ITEM_NOT_FOUND));
        toDoRepo.delete(toDoItem);
    }

    public ToDoItem putItem(Long id, ToDoItem toDoItem) {
        return toDoRepo.findById(id)
                .map(toDoUpdated -> {
                    toDoUpdated.setTitle(toDoItem.getTitle());
                    toDoUpdated.setDone(toDoItem.isDone());
                    return toDoRepo.save(toDoUpdated);
                })
                .orElseThrow(() -> new ToDoException(ToDoError.ITEM_NOT_FOUND));
    }

    public ToDoItem patchItem(Long id, ToDoItem toDoItem) {
        return toDoRepo.findById(id)
                .map(toDoUpdated -> {
                    if (!StringUtils.isEmpty(toDoItem.getTitle()))
                        toDoUpdated.setTitle(toDoItem.getTitle());
                    toDoUpdated.setDone(toDoItem.isDone());
                    return toDoRepo.save(toDoUpdated);
                })
                .orElseThrow(() -> new ToDoException(ToDoError.ITEM_NOT_FOUND));
    }

    public void markAsDone(Long id) {
        ToDoItem toDoItem = toDoRepo.findById(id)
                .orElseThrow(() -> new ToDoException(ToDoError.ITEM_NOT_FOUND));
        toDoItem.setDone(true);
        toDoRepo.save(toDoItem);
    }

}
