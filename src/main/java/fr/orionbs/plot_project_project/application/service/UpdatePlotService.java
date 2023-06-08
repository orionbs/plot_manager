package fr.orionbs.plot_project_project.application.service;

import fr.orionbs.plot_project_project.adapter.persistence.plot.exception.NullPlotPersistenceException;
import fr.orionbs.plot_project_project.application.port.input.UpdatePlotUseCase;
import fr.orionbs.plot_project_project.application.port.output.*;
import fr.orionbs.plot_project_project.domain.exception.NullPlotException;
import fr.orionbs.plot_project_project.domain.model.Municipality;
import fr.orionbs.plot_project_project.domain.model.Plot;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UpdatePlotService implements UpdatePlotUseCase {

    private final Log LOGGER = LogFactory.getLog(UpdatePlotService.class);
    private final SelectMunicipalityPort selectMunicipalityPort;
    private final SelectPlotPort selectPlotPort;
    private final ExistPlotPort existPlotPort;
    private final InsertPlotPort insertPlotPort;
    private final UpdatePlotPort updatePlotPort;

    @Override
    public void updatePlot() {

        List<Municipality> municipalities = selectMunicipalityPort.selectMunicipalities();

        for (Municipality municipality : municipalities) {

            List<Plot> plots = selectPlotPort.selectPlotsFromOneMunicipality(municipality.getMunicipalityCode());

            for (Plot plot : plots) {

                if (existPlotPort.existPlotById(plot.getId())) {

                    plot = updatePlotPort.updatePlot(plot);

                } else {

                    try {
                        plot = insertPlotPort.insertPlot(plot);
                    } catch (NullPlotPersistenceException | NullPlotException e) {
                        throw new RuntimeException(e);
                    }


                }


            }

        }

    }

}
