package fr.orionbs.plot_project_project.adapter.client.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeatureCollectionTemplate {
    private String type;
    private List<FeatureTemplate> features = new ArrayList<>();
}
