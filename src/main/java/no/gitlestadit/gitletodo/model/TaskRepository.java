package no.gitlestadit.gitletodo.model;

import java.sql.Types;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import no.gitlestadit.gitletodo.db.GitletodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TaskRepository extends GitletodoRepository {

    private static Logger logger = LoggerFactory.getLogger(TaskRepository.class);

    public TaskRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public List<Task> getTasks() {
        String query = "SELECT id, title from task";

        return jdbcTemplate.query(query, taskRowMapper);
    }

    public Optional<Task> getTask(String id) {
        String query = "SELECT id, title from task"
            + " WHERE id = CAST(:id AS uuid)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id, Types.VARCHAR);

        List<Task> list = jdbcTemplate.query(query, params, taskRowMapper);
        return list.stream()
            .findFirst();
    }

    public void addTask(Task task) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", task.id.toString(), Types.VARCHAR);
        params.addValue("title", task.title, Types.VARCHAR);

        String query = "INSERT INTO task(id, title)"
            + " VALUES (CAST(:id AS uuid), :title)";
        jdbcTemplate.update(query, params);
    }

    private RowMapper<Task> taskRowMapper = createTaskRowMapper();

    private RowMapper<Task> createTaskRowMapper() {
        return (rs, rowNum) -> Task.builder()
            .title(rs.getString("title"))
            .id(UUID.fromString(rs.getString("id")))
            .build();
    }
}

