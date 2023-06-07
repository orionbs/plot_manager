package fr.orionbs.plot_project_project.domain.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Column(name = "number", updatable = false, nullable = false, unique = true)
    private String number;
}
