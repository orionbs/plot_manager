package fr.orionbs.plot_project_project.application.port.output;

import fr.orionbs.plot_project_project.adapter.persistence.plot.exception.NullPlotPersistenceException;
import fr.orionbs.plot_project_project.domain.exception.NullPlotException;
import fr.orionbs.plot_project_project.domain.model.Plot;

public interface InsertPlotPort {
    Plot insertPlot(Plot plot) throws NullPlotException, NullPlotPersistenceException;
}
