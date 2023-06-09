package fr.orionbs.plot_manager.adapter.client.municipality.template;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GeometryTemplate {
    private String type;
    private List<Double> coordinates = new ArrayList<>();
}
