package no.gitlestadit.gitletodo.rest;

import java.util.List;
import java.util.UUID;
import no.gitlestadit.gitletodo.model.Task;
import no.gitlestadit.gitletodo.model.NewTask;
import no.gitlestadit.gitletodo.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: oddgeir Created: 10.11.2018.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskRepository taskRepository;

    @Autowired
    public TaskController(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping(
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public List<Task> getTasks() {
        return taskRepository.getTasks();
    }

    @PostMapping(
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Task addTask(NewTask taskDto) {
        Task newTask = Task.builder()
                .title(taskDto.getTitle())
                .id(UUID.randomUUID())
                .build();
        taskRepository.addTask(newTask);
        return newTask;
    }
}
