package fr.orionbs.plot_manager.domain.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Plot {
    private String id;
    private History history;
    private Information information;
    private List<Coordinate> coordinates = new ArrayList<>();
}
