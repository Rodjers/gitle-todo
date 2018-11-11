package no.gitlestadit.gitletodo.db;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public abstract class GitletodoRepository {

    protected NamedParameterJdbcTemplate jdbcTemplate;

    protected GitletodoRepository() {
    }

    public GitletodoRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    protected Optional<String> getOptionalFirstString(String query, MapSqlParameterSource params) {
        List<String> strings = jdbcTemplate.queryForList(query, params, String.class);
        if (strings.size() > 0) {
            return Optional.of(strings.get(0));
        }

        return Optional.empty();
    }

    protected Optional<UUID> getOptionalFirstUuid(String query, MapSqlParameterSource params) {
        List<String> strings = jdbcTemplate.queryForList(query, params, String.class);
        if (strings.size() > 0) {
            return Optional.of(UUID.fromString(strings.get(0)));
        }

        return Optional.empty();
    }
}
