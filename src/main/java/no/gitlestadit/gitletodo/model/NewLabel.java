package no.gitlestadit.gitletodo.model;

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
public class NewLabel {
    UUID id;
    String name;
    String path;
    UUID user;
}
