package no.gitlestadit.gitletodo.model;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: oddgeir Created: 10.11.2018.
 */
@Data
@Getter
@Setter
@Builder
public class Task {
    UUID id;
    String title;
}
