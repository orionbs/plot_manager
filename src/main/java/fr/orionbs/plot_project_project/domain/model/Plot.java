package fr.orionbs.plot_project_project.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plot {
    private String id;
    private History history;
    private Information information;
    private List<Coordinate> coordinates = new ArrayList<>();
}
