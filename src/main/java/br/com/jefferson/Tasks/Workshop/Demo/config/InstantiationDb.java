package br.com.jefferson.Tasks.Workshop.Demo.config;

import br.com.jefferson.Tasks.Workshop.Demo.domain.Task;
import br.com.jefferson.Tasks.Workshop.Demo.repositories.TaskRepository;
import br.com.jefferson.Tasks.Workshop.Demo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

@Configuration
@Profile("test")
public class InstantiationDb implements CommandLineRunner {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        clearDb();
        Task task1= new Task(null,"Fazer a 5ª atividade de LP", LocalDate.of(2025,10,02));
        Task task2 = new Task(null,"Fazer o projeto da unidade 3 de LP", LocalDate.of(2025,10,03));
        Task task3 = new Task(null,"Lavar a louça", LocalDate.of(2025,10,02));
        taskRepository.saveAll(Arrays.asList(task1,task2,task3));
    }

    private void clearDb() {
        taskRepository.deleteAll();
    }
}
