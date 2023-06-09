package fr.orionbs.plot_manager.application.port.output;

import fr.orionbs.plot_manager.domain.model.Plot;

public interface UpdatePlotPort {
    Plot updatePlot(Plot plot);
}
