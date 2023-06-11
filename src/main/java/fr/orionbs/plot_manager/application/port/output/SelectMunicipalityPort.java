package fr.orionbs.plot_manager.application.port.output;

import fr.orionbs.plot_manager.domain.model.Municipality;

import java.util.Optional;

public interface SelectMunicipalityPort {
    Optional<Municipality> selectMunicipalityByPostalCode(String postalCode);
}
