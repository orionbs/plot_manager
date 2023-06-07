package fr.orionbs.plot_project_project.adapter.client.plot.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import fr.orionbs.plot_project_project.domain.model.History;
import fr.orionbs.plot_project_project.domain.model.Information;
import fr.orionbs.plot_project_project.domain.model.Plot;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PlotMapper {

    public Plot toPlot(JsonNode feature) {
        Plot plot = new Plot();
        JsonNode properties = feature.get("properties");
        plot.setId(properties.get("id").asText());

        History history = new History();
        history.setDateOfCreation(LocalDate.parse(properties.get("created").asText()));
        history.setDateOfLastUpdate(LocalDate.parse(properties.get("updated").asText()));
        plot.setHistory(history);

        Information information = new Information();
        information.setSection(properties.get("section").asText());
        information.setNumber(properties.get("numero").asText());
        if (properties.get("prefix") != null) {
            information.setPrefix(properties.get("prefix").asText());
        }
        information.setCheck(Boolean.valueOf(properties.get("arpente").asText()));
        information.setPostalCode(properties.get("commune").asText());

        return plot;
    }
}
