package fr.orionbs.plot_manager.application.port.output;

import fr.orionbs.plot_manager.domain.model.Plot;

import java.util.List;

public interface SelectPlotPort {
    List<Plot> selectPlotsFromOneMunicipality(String municipalityCode);
}
