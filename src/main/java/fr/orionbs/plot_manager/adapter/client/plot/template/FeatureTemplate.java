package fr.orionbs.plot_manager.adapter.client.plot.template;

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
