package fr.orionbs.plot_manager.application.port.output;

import fr.orionbs.plot_manager.adapter.persistence.municipality.exception.UnknownMunicipalityPersistenceException;
import fr.orionbs.plot_manager.domain.model.Municipality;

import java.util.List;

public interface SelectMunicipalityPort {
    List<Municipality> selectMunicipalities();

    Municipality selectMunicipalityByMunicipalityCode(String municipalityCode) throws UnknownMunicipalityPersistenceException;
}
