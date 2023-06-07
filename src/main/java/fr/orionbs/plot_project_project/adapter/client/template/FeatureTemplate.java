package fr.orionbs.plot_project_project.adapter.client.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeatureTemplate {
    private String id;
    private String type;
    private PolygonTemplate geometry;
    private PropertiesTemplate properties;
}
