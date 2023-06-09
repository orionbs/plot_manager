package fr.orionbs.plot_manager.domain.model;

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
