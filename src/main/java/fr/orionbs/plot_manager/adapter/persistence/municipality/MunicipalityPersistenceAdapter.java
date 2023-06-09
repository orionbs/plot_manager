package fr.orionbs.plot_manager.adapter.persistence.municipality;

import fr.orionbs.plot_manager.adapter.persistence.municipality.exception.UnknownMunicipalityPersistenceException;
import fr.orionbs.plot_manager.adapter.persistence.municipality.mapper.MunicipalityMapper;
import fr.orionbs.plot_manager.adapter.persistence.municipality.repository.MunicipalityRepository;
import fr.orionbs.plot_manager.application.port.output.SelectMunicipalityPort;
import fr.orionbs.plot_manager.domain.model.Municipality;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MunicipalityPersistenceAdapter implements SelectMunicipalityPort {

    private final Log LOGGER = LogFactory.getLog(MunicipalityPersistenceAdapter.class);
    private final MunicipalityRepository municipalityRepository;
    private final MunicipalityMapper municipalityMapper;

    @Override
    public List<Municipality> selectMunicipalities() {
        LOGGER.debug("Selecting all municipality on the database.");
        return municipalityRepository.findAll().stream().map(municipalityMapper::toMunicipality).collect(Collectors.toList());
    }

    @Override
    public Municipality selectMunicipalityByMunicipalityCode(String municipalityCode) throws UnknownMunicipalityPersistenceException {
        LOGGER.debug("Selecting one municipality on the database with his municipality code: " + municipalityCode);
        return municipalityRepository.findMunicipalityEntityByMunicipalityCodeIgnoreCase(municipalityCode).map(municipalityMapper::toMunicipality).orElseThrow(UnknownMunicipalityPersistenceException::new);
    }
}
