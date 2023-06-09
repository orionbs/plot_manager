package fr.orionbs.plot_manager.adapter.client.plot;

import fr.orionbs.plot_manager.adapter.client.plot.mapper.PlotClientMapper;
import fr.orionbs.plot_manager.adapter.client.plot.proxy.PlotProxy;
import fr.orionbs.plot_manager.adapter.client.plot.template.FeatureCollectionTemplate;
import fr.orionbs.plot_manager.application.port.output.SelectPlotPort;
import fr.orionbs.plot_manager.domain.model.Plot;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class PlotClientAdapter implements SelectPlotPort {

    private final PlotProxy plotProxy;
    private final PlotClientMapper plotClientMapper;

    @Override
    public List<Plot> selectPlotsFromOneMunicipality(String municipalityCode) {

        LocalDateTime startDateTime = LocalDateTime.now();

        FeatureCollectionTemplate featureCollectionTemplate = plotProxy.getPlotOfOneMunicipality(municipalityCode);

        Duration duration = Duration.between(startDateTime, LocalDateTime.now());

        log.debug("It takes " + duration.toMinutesPart() + " minute(s), " + duration.toSecondsPart() + " second(s), " + duration.toMillisPart() + " millisecond(s) to download plots of municipality code: " + municipalityCode + ".");

        return featureCollectionTemplate.getFeatures()
                .stream()
                .map(plotClientMapper::toPlot)
                .collect(Collectors.toList());

    }

}
