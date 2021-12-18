package pl.TOstrowski.ToDoList.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TodoItem {

    @GeneratedValue
    @Id
    private Long id;

    @NotBlank
    private String title;
    private boolean done;

}
