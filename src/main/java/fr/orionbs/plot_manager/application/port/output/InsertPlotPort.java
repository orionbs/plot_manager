package fr.orionbs.plot_manager.application.port.output;

import fr.orionbs.plot_manager.adapter.persistence.plot.exception.NullPlotPersistenceException;
import fr.orionbs.plot_manager.domain.exception.NullPlotException;
import fr.orionbs.plot_manager.domain.model.Plot;

public interface InsertPlotPort {
    Plot insertPlot(Plot plot) throws NullPlotException, NullPlotPersistenceException;
}
