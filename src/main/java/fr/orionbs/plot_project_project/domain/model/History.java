package fr.orionbs.plot_project_project.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class History {
    private LocalDate dateOfCreation;
    private LocalDate dateOfLastUpdate;
}
