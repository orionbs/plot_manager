package fr.orionbs.plot_project_project.adapter.client.template;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FeatureCollectionTemplate {
    private String type;
    private List<FeatureTemplate> features = new ArrayList<>();
}
