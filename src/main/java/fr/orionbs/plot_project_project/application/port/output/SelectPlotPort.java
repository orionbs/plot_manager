package fr.orionbs.plot_project_project.application.port.output;

import com.fasterxml.jackson.core.JsonProcessingException;
import fr.orionbs.plot_project_project.domain.model.Plot;

import java.util.List;

public interface SelectPlotPort {
    List<Plot> selectPlotsFromOneMunicipality(String municipalityCode);
}
