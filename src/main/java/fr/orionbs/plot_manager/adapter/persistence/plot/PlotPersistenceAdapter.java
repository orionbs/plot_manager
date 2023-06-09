package fr.orionbs.plot_manager.adapter.persistence.plot;

import fr.orionbs.plot_manager.adapter.persistence.plot.entity.PlotEntity;
import fr.orionbs.plot_manager.adapter.persistence.plot.exception.NullPlotPersistenceException;
import fr.orionbs.plot_manager.adapter.persistence.plot.mapper.PlotPersistenceMapper;
import fr.orionbs.plot_manager.adapter.persistence.plot.repository.PlotRepository;
import fr.orionbs.plot_manager.application.port.output.ExistPlotPort;
import fr.orionbs.plot_manager.application.port.output.InsertPlotPort;
import fr.orionbs.plot_manager.application.port.output.UpdatePlotPort;
import fr.orionbs.plot_manager.domain.exception.NullPlotException;
import fr.orionbs.plot_manager.domain.model.Plot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlotPersistenceAdapter implements ExistPlotPort, InsertPlotPort, UpdatePlotPort {

    private final PlotRepository plotRepository;
    private final PlotPersistenceMapper plotPersistenceMapper;

    @Override
    public boolean existPlotById(String id) {
        return plotRepository.existsById(id);
    }

    @Override
    public Plot insertPlot(Plot plot) throws NullPlotException, NullPlotPersistenceException {

        if (plot != null && plot.getId() != null && !plot.getId().isBlank()) {

            PlotEntity plotEntity = new PlotEntity();
            plotEntity.setId(plot.getId());

            plotEntity = plotRepository.save(plotEntity);
            return plotPersistenceMapper.toPlot(plotEntity);

        } else {
            throw new NullPlotException();
        }

    }

    @Override
    public Plot updatePlot(Plot plot) {
        return null;
    }
}
