package fr.orionbs.plot_manager.adapter.client.municipality;

import fr.orionbs.plot_manager.adapter.client.municipality.mapper.MunicipalityClientMapper;
import fr.orionbs.plot_manager.adapter.client.municipality.proxy.MunicipalityProxy;
import fr.orionbs.plot_manager.adapter.client.municipality.template.MunicipalityTemplate;
import fr.orionbs.plot_manager.application.port.output.DownloadMunicipalityPort;
import fr.orionbs.plot_manager.domain.model.Municipality;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class MunicipalityClientAdapter implements DownloadMunicipalityPort {

    private final MunicipalityProxy municipalityProxy;
    private final MunicipalityClientMapper municipalityClientMapper;

    @Override
    public List<Municipality> downloadMunicipalities() {

        log.debug("Starting fetching municipalities from external api.");

        LocalDateTime startDateTime = LocalDateTime.now();

        List<MunicipalityTemplate> municipalityTemplates = municipalityProxy.getAllMunicipalityOfFrance();

        Duration duration = Duration.between(startDateTime, LocalDateTime.now());

        log.debug("It takes " + duration.toMinutesPart() + " minute(s), " + duration.toSecondsPart() + " second(s), " + duration.toMillisPart() + " millisecond(s) to download every municipality of France.");

        return municipalityTemplates
                .stream()
                .map(municipalityClientMapper::toMunicipality)
                .distinct()
                .collect(Collectors.toList());
    }

}
