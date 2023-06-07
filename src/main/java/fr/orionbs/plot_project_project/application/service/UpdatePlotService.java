package fr.orionbs.plot_project_project.application.service;

import fr.orionbs.plot_project_project.application.port.input.UpdatePlotUseCase;
import fr.orionbs.plot_project_project.application.port.output.*;
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
/*    private final ExistPlotPort existPlotPort;
    private final InsertPlotPort insertPlotPort;
    private final UpdatePlotPort updatePlotPort;*/

    @Override
    public void updatePlot() {

        // First, we need find all the department from the database that we need to handle.
        List<Municipality> municipalities = selectMunicipalityPort.selectMunicipalities();

        // Second, we need to iterate on each department to find all municipalities of the department.
        for (Municipality municipality : municipalities) {

            List<Plot> plots = selectPlotPort.selectPlotsFromOneMunicipality(municipality.getMunicipalityCode());

            // Fourth, we can insert or update each plot.

            for (Plot plot : plots) {

                LOGGER.debug(plot.toString());

             /*   if (existPlotPort.existPlotById(plot.getId())) {
                    plot = updatePlotPort.updatePlot(plot);
                } else {
                    plot = insertPlotPort.insertPlot(plot);
                }*/


            }

        }

    }

}
