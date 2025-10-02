package br.com.jefferson.Tasks.Workshop.Demo.controller;

import br.com.jefferson.Tasks.Workshop.Demo.domain.Task;
import br.com.jefferson.Tasks.Workshop.Demo.domain.dto.TaskDTO;
import br.com.jefferson.Tasks.Workshop.Demo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/create")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("create");
        mv.addObject("task", new TaskDTO());
        return mv;
    }

    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("tasks", this.taskService.findAll());
        return mv;
    }

    @PostMapping("/create")
    public String create(TaskDTO taskDTO) {
        if(taskDTO.getId() != null){
            this.taskService.update(taskDTO.getId(), taskDTO);
        } else {
            Task task = this.taskService.create(taskDTO);
        }
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("create");
        Task task = this.taskService.findById(id);
        TaskDTO taskDTO = new TaskDTO(task.getId(), task.getName(), task.getDate());
        mv.addObject("task", taskDTO);
        return mv;
    }
//    @GetMapping
//    public ResponseEntity<List<TaskDTO>> findAll() {
//        List<TaskDTO> taskDTOS = this.taskService.findAll().stream().map(t -> toDTO(t) ).collect(Collectors.toList());
//        return ResponseEntity.ok(taskDTOS);
//    }

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<TaskDTO> findById(@PathVariable Long id) {
//        Task task = this.taskService.findById(id);
//        return ResponseEntity.ok(toDTO(task));
//    }

//    @PutMapping(value = "/{id}")
//    public ResponseEntity<TaskDTO> update(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
//        Task task = this.taskService.update(id, taskDTO);
//        return ResponseEntity.ok(toDTO(task));
//    }
//
//    @DeleteMapping(value ="/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        this.taskService.delete(id);
//        return ResponseEntity.noContent().build();
//    }

    private TaskDTO toDTO(Task task) {
        return new TaskDTO(task.getId(), task.getName(), task.getDate());
    }
}
