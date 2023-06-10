package fr.orionbs.plot_manager.adapter.persistence.plot.mapper;

import fr.orionbs.plot_manager.adapter.persistence.plot.entity.PlotEntity;
import fr.orionbs.plot_manager.adapter.persistence.plot.exception.NullPlotPersistenceException;
import fr.orionbs.plot_manager.domain.model.Plot;
import org.springframework.stereotype.Component;

@Component
public class PlotPersistenceMapper {

    public Plot toPlot(PlotEntity plotEntity) throws NullPlotPersistenceException {

        if (plotEntity != null) {

            Plot plot = new Plot();
            plot.setId(plotEntity.getId());

            return plot;

        } else {
            throw new NullPlotPersistenceException();
        }

    }

}
