package fr.orionbs.plot_manager.application.port.input;

public interface DownloadMunicipalityUseCase {
    /**
     * <li>Download municipality data from external api.</li>
     * <li>Verify if each municipality exist and if so update them or insert them.</li>
     * <li>Persist each municipality on the database.</li>
     */
    void downloadMunicipality();
}
