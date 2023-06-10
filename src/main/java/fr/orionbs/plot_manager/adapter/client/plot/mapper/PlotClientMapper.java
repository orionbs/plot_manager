package fr.orionbs.plot_manager.adapter.client.plot.mapper;

import fr.orionbs.plot_manager.adapter.client.plot.template.FeatureTemplate;
import fr.orionbs.plot_manager.adapter.client.plot.template.PropertiesTemplate;
import fr.orionbs.plot_manager.domain.model.Coordinate;
import fr.orionbs.plot_manager.domain.model.History;
import fr.orionbs.plot_manager.domain.model.Information;
import fr.orionbs.plot_manager.domain.model.Plot;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Component
public class PlotClientMapper {

    Log LOGGER = LogFactory.getLog(PlotClientMapper.class);

    public Plot toPlot(FeatureTemplate featureTemplate) {

        Plot plot = new Plot();

        if (featureTemplate.getId() != null && !featureTemplate.getId().isBlank()) {
            plot.setId(featureTemplate.getId());
        }

        if (featureTemplate.getProperties() != null) {

            PropertiesTemplate propertiesTemplate = featureTemplate.getProperties();

            History history = new History();

            if (propertiesTemplate.getCreated() != null && !propertiesTemplate.getCreated().isBlank()) {
                try {
                    history.setDateOfCreation(LocalDate.parse(propertiesTemplate.getCreated()));
                } catch (DateTimeParseException dateTimeParseException) {
                    LOGGER.debug("Creation date of the plot isn't parseable.");
                }
            }

            if (propertiesTemplate.getUpdated() != null && !propertiesTemplate.getUpdated().isBlank()) {
                try {
                    history.setDateOfLastUpdate(LocalDate.parse(propertiesTemplate.getUpdated()));
                } catch (DateTimeParseException dateTimeParseException) {
                    LOGGER.debug("Update date of the plot isn't parseable.");
                }
            }

            plot.setHistory(history);

            Information information = new Information();

            if (propertiesTemplate.getSection() != null && !propertiesTemplate.getSection().isBlank()) {
                information.setSection(propertiesTemplate.getSection());
            }

            if (propertiesTemplate.getNumero() != null && !propertiesTemplate.getNumero().isBlank()) {
                information.setNumber(propertiesTemplate.getNumero());
            }

            if (propertiesTemplate.getPrefixe() != null && !propertiesTemplate.getPrefixe().isBlank()) {
                information.setPrefix(propertiesTemplate.getPrefixe());
            }

            if (propertiesTemplate.getArpente() != null && !propertiesTemplate.getArpente().isBlank()) {
                information.setCheck(Boolean.parseBoolean(propertiesTemplate.getArpente()));
            }

            if (propertiesTemplate.getCommune() != null && !propertiesTemplate.getCommune().isBlank()) {
                information.setMunicipalityCode(propertiesTemplate.getCommune());
            }

            plot.setInformation(information);


        }

        if (featureTemplate.getGeometry() != null) {

            plot.getCoordinates().addAll(
                    featureTemplate.getGeometry().getCoordinates().get(0)
                            .stream()
                            .map(coordinateArray -> {
                                Coordinate coordinate = new Coordinate();
                                if (coordinateArray.size() == 2) {
                                    coordinate.setLongitude(coordinateArray.get(0));
                                    coordinate.setLatitude(coordinateArray.get(1));
                                    return coordinate;
                                } else {
                                    throw new RuntimeException("The coordinate aren't properly configured.");
                                }
                            })
                            .toList()
            );

        }

        return plot;
    }
}
