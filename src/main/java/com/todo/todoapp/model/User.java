package com.todo.todoapp.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JoinTable(name = "user_task",
            joinColumns = {@JoinColumn(name = "user_id",
            referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "task_id",
            referencedColumnName = "id")})
    private List<Task> taskList;


    public User(String name, String email, List<Task> taskList) {
        this.name = name;
        this.email = email;
        this.taskList = taskList;
    }

}
