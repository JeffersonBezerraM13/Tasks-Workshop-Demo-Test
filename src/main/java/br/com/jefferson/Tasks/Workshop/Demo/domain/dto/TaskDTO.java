package br.com.jefferson.Tasks.Workshop.Demo.domain.dto;

import br.com.jefferson.Tasks.Workshop.Demo.domain.Task;

import java.util.Date;

public class TaskDTO {
    private Long id;
    private String name;
    private Date date;

    public TaskDTO() {
    }

    public TaskDTO(Long id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.name = task.getName();
        this.date = task.getDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
