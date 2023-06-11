package fr.orionbs.plot_manager.application.port.output;

import fr.orionbs.plot_manager.adapter.persistence.municipality.exception.MunicipalityPersistenceException;
import fr.orionbs.plot_manager.domain.model.Municipality;

public interface UpdateMunicipalityPort {
    Municipality updateMunicipalityByMunicipalityCode(Municipality municipality) throws MunicipalityPersistenceException;
}
