package fr.orionbs.plot_manager.application.port.output;

public interface ExistMunicipalityPort {
    Boolean existMunicipalityByPostalCode(String postalCode);

    Boolean existMunicipalityByMunicipalityCode(String municipalityCode);
}
