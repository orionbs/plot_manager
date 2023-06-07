package fr.orionbs.plot_project_project.application.port.output;

import fr.orionbs.plot_project_project.domain.model.Plot;

public interface InsertPlotPort {
    Plot insertPlot(Plot plot);
}
