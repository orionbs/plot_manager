package fr.orionbs.plot_project_project.adapter.client.plot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fr.orionbs.plot_project_project.adapter.client.plot.mapper.PlotMapper;
import fr.orionbs.plot_project_project.adapter.client.plot.proxy.PlotProxy;
import fr.orionbs.plot_project_project.application.port.output.SelectPlotPort;
import fr.orionbs.plot_project_project.domain.model.Plot;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PlotClientAdapter implements SelectPlotPort {

    private final Log LOGGER = LogFactory.getLog(PlotClientAdapter.class);
    private final PlotProxy plotProxy;
    private final PlotMapper plotMapper;

    @Override
    public List<Plot> selectPlotsFromOneMunicipality(String municipalityCode) {

        String featureCollectionString = plotProxy.getPlotOfOneMunicipality(municipalityCode);

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode featureCollection = null;
        try {
            featureCollection = objectMapper.readValue(featureCollectionString, JsonNode.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        JsonNode features = featureCollection.get("features");
        ArrayNode featureArray = (ArrayNode) features;

        List<Plot> plots = new ArrayList<>();

        featureArray.forEach(jsonNode -> {
            plots.add(plotMapper.toPlot(jsonNode));
        });

        return plots;
    }

}
