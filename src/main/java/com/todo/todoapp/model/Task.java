package com.todo.todoapp.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @ManyToOne
    @JsonIgnore
    @JoinTable(name = "user_task",
            joinColumns = {
            @JoinColumn(name = "task_id",
            insertable = false,
            updatable = false,
            referencedColumnName = "id")},
            inverseJoinColumns = {
            @JoinColumn(name = "user_id",
            insertable = false,
            updatable = false,
            referencedColumnName = "id")}
    )
    private User user;

    public Task(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
    }

}
