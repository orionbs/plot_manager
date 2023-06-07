package fr.orionbs.plot_project_project.application.port.output;

import fr.orionbs.plot_project_project.adapter.persistence.municipality.exception.UnknownMunicipalityPersistenceException;
import fr.orionbs.plot_project_project.domain.model.Municipality;

import java.util.List;

public interface SelectMunicipalityPort {
    List<Municipality> selectMunicipalities();

    Municipality selectMunicipalityByMunicipalityCode(String municipalityCode) throws UnknownMunicipalityPersistenceException;
}
