package com.todo.todoapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

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

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "task_date")
    private LocalDate date;

    public Task(String title, String description, User user, LocalDate date) {
        this.title = title;
        this.description = description;
        this.user = user;
        this.date = date;
    }

}
