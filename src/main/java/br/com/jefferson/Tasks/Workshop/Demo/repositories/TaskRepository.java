package br.com.jefferson.Tasks.Workshop.Demo.repositories;

import br.com.jefferson.Tasks.Workshop.Demo.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
