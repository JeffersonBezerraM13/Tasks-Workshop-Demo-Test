package br.com.jefferson.Tasks.Workshop.Demo.resources;

import br.com.jefferson.Tasks.Workshop.Demo.domain.Task;
import br.com.jefferson.Tasks.Workshop.Demo.domain.dto.TaskDTO;
import org.aspectj.weaver.ast.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.jefferson.Tasks.Workshop.Demo.services.TaskService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskDTO>> findAll() {
        List<TaskDTO> taskDTOS = this.taskService.findAll().stream().map(t -> toDTO(t) ).collect(Collectors.toList());
        return ResponseEntity.ok(taskDTOS);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable Long id) {
        Task task = this.taskService.findById(id);
        return ResponseEntity.ok(toDTO(task));
    }

    @PostMapping
    public ResponseEntity<TaskDTO> create(@RequestBody TaskDTO taskDTO) {
        Task task = this.taskService.create(taskDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(task.getId()).toUri();
        return ResponseEntity.created(uri).body(toDTO(task));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TaskDTO> update(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        Task task = this.taskService.update(id, taskDTO);
        return ResponseEntity.ok(toDTO(task));
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private TaskDTO toDTO(Task task) {
        return new TaskDTO(task.getId(),task.getName(),task.getDate());
    }
}
