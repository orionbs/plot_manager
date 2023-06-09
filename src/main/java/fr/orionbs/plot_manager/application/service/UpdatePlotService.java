package fr.orionbs.plot_manager.application.service;

import fr.orionbs.plot_manager.adapter.persistence.plot.exception.NullPlotPersistenceException;
import fr.orionbs.plot_manager.application.port.input.UpdatePlotUseCase;
import fr.orionbs.plot_manager.application.port.output.*;
import fr.orionbs.plot_manager.domain.exception.NullPlotException;
import fr.orionbs.plot_manager.domain.model.Municipality;
import fr.orionbs.plot_manager.domain.model.Plot;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpdatePlotService implements UpdatePlotUseCase {

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
