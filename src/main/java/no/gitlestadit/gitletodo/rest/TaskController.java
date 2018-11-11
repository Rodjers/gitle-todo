package no.gitlestadit.gitletodo.rest;

import java.util.Collections;
import java.util.List;
import no.gitlestadit.gitletodo.model.Label;
import no.gitlestadit.gitletodo.model.Task;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: oddgeir Created: 10.11.2018.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {


    @GetMapping(
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public List<Task> getTasks() {
        Label label = Label.builder().name("Work").build();
        Task task = Task.builder()
            .title("Do stuff")
            .description("What to do")
            .labels(Collections.singletonList(label))
            .build();
        return Collections.singletonList(task);
    }
}
