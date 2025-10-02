package br.com.jefferson.Tasks.Workshop.Demo.domain.dto;

import br.com.jefferson.Tasks.Workshop.Demo.domain.Task;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskDTO {
    private static final DateTimeFormatter BRAZILIAN_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Long id;
    private String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    public TaskDTO() {
    }

    public TaskDTO(Long id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.name = task.getName();
        this.date = task.getDate();
    }

    public String getDateString() {
        if (date == null) return "";
        return date.format(BRAZILIAN_FORMAT);
    }

    public void setDateString(String dateString) {
        if (dateString == null || dateString.isBlank()) {
            this.date = null;
        } else {
            this.date = LocalDate.parse(dateString, BRAZILIAN_FORMAT);
        }
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
