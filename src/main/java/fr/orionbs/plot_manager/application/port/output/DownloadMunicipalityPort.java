package fr.orionbs.plot_manager.application.port.output;

import fr.orionbs.plot_manager.domain.model.Municipality;

import java.util.List;

public interface DownloadMunicipalityPort {
    List<Municipality> downloadMunicipalities();
}
