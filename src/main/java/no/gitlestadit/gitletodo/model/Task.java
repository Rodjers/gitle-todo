package no.gitlestadit.gitletodo.model;

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
    String name;


}
