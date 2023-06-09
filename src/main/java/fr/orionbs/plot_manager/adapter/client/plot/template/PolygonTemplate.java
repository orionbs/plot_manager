package fr.orionbs.plot_manager.adapter.client.plot.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolygonTemplate {

    private String type;
    private List<List<List<Double>>> coordinates;

}
