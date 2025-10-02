package br.com.jefferson.Tasks.Workshop.Demo.services;

import br.com.jefferson.Tasks.Workshop.Demo.domain.Task;
import br.com.jefferson.Tasks.Workshop.Demo.domain.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.jefferson.Tasks.Workshop.Demo.repositories.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public List<Task> findAll() {
        return this.repository.findAll();
    }

    public Task findById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    public Task create(TaskDTO taskDTO) {
        return this.repository.save(new Task(taskDTO));
    }

    public Task update(Long id, TaskDTO taskDTO) {
        taskDTO.setId(id);
        return this.repository.save(new Task(taskDTO));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
