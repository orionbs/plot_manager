package fr.orionbs.plot_manager.adapter.persistence.plot;

import fr.orionbs.plot_manager.adapter.persistence.plot.entity.CoordinateEntity;
import fr.orionbs.plot_manager.adapter.persistence.plot.entity.PlotEntity;
import fr.orionbs.plot_manager.adapter.persistence.plot.exception.NullPlotPersistenceException;
import fr.orionbs.plot_manager.adapter.persistence.plot.mapper.PlotPersistenceMapper;
import fr.orionbs.plot_manager.adapter.persistence.plot.repository.CoordinateRepository;
import fr.orionbs.plot_manager.adapter.persistence.plot.repository.PlotRepository;
import fr.orionbs.plot_manager.application.port.output.ExistPlotPort;
import fr.orionbs.plot_manager.application.port.output.InsertPlotPort;
import fr.orionbs.plot_manager.application.port.output.UpdatePlotPort;
import fr.orionbs.plot_manager.domain.exception.NullPlotException;
import fr.orionbs.plot_manager.domain.model.Coordinate;
import fr.orionbs.plot_manager.domain.model.Plot;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@RequiredArgsConstructor
@Slf4j
public class PlotPersistenceAdapter implements ExistPlotPort, InsertPlotPort, UpdatePlotPort {

    private final PlotRepository plotRepository;
    private final CoordinateRepository coordinateRepository;
    private final PlotPersistenceMapper plotPersistenceMapper;

    @Override
    public boolean existPlotById(String id) {
        return plotRepository.existsById(id);
    }

    @Override
    @Transactional
    public Plot insertPlot(Plot plot) throws NullPlotException, NullPlotPersistenceException {

        if (plot != null && plot.getId() != null && !plot.getId().isBlank()) {

            PlotEntity plotEntity = new PlotEntity();
            plotEntity.setId(plot.getId());

            if (plot.getHistory() != null) {

                if (plot.getHistory().getDateOfCreation() != null) {
                    plotEntity.setCreation(Timestamp.valueOf(plot.getHistory().getDateOfCreation().atStartOfDay()));
                }

                if (plot.getHistory().getDateOfLastUpdate() != null) {
                    plotEntity.setLastUpdate(Timestamp.valueOf(plot.getHistory().getDateOfLastUpdate().atStartOfDay()));
                }

            }

            if (plot.getInformation() != null) {

                if (plot.getInformation().getMunicipalityCode() != null && !plot.getInformation().getMunicipalityCode().isBlank()) {
                    plotEntity.setMunicipalityCode(plot.getInformation().getMunicipalityCode());
                }

                if (plot.getInformation().getPostalCode() != null && !plot.getInformation().getPostalCode().isBlank()) {
                    plotEntity.setPostalCode(plot.getInformation().getPostalCode());
                }

                if (plot.getInformation().getSection() != null && !plot.getInformation().getSection().isBlank()) {
                    plotEntity.setSection(plot.getInformation().getSection());
                }

                if (plot.getInformation().getNumber() != null && !plot.getInformation().getNumber().isBlank()) {
                    plotEntity.setNumber(plot.getInformation().getNumber());
                }

                if (plot.getInformation().getPrefix() != null && !plot.getInformation().getPrefix().isBlank()) {
                    plotEntity.setPrefix(plot.getInformation().getPrefix());
                }

                plotEntity.setVerify(plot.getInformation().isCheck());

            }

            plotEntity = plotRepository.save(plotEntity);

            if (!plot.getCoordinates().isEmpty()) {

                for (Coordinate coordinate : plot.getCoordinates()) {

                    CoordinateEntity coordinateEntity = new CoordinateEntity();
                    coordinateEntity.setLongitude(coordinate.getLongitude());
                    coordinateEntity.setLatitude(coordinate.getLatitude());
                    coordinateEntity.setPlot(plotEntity);
                    coordinateRepository.save(coordinateEntity);
                    plotEntity.getCoordinates().add(coordinateEntity);

                }

            }

            log.debug("Plot insertion, id: " + plotEntity.getId());

            return plotPersistenceMapper.toPlot(plotEntity);

        } else {
            throw new NullPlotException();
        }

    }

    @Override
    public Plot updatePlot(Plot plot) {

        log.debug("Plot update, id: " + null);

        return null;
    }
}
