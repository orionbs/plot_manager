package fr.orionbs.plot_manager.application.service;

import fr.orionbs.plot_manager.adapter.persistence.municipality.exception.MunicipalityPersistenceException;
import fr.orionbs.plot_manager.application.port.input.DownloadMunicipalityUseCase;
import fr.orionbs.plot_manager.application.port.output.DownloadMunicipalityPort;
import fr.orionbs.plot_manager.application.port.output.ExistMunicipalityPort;
import fr.orionbs.plot_manager.application.port.output.InsertMunicipalityPort;
import fr.orionbs.plot_manager.application.port.output.UpdateMunicipalityPort;
import fr.orionbs.plot_manager.domain.exception.DownloadMunicipalityException;
import fr.orionbs.plot_manager.domain.model.Municipality;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DownloadMunicipalityService implements DownloadMunicipalityUseCase {

    private final DownloadMunicipalityPort downloadMunicipalityPort;
    private final ExistMunicipalityPort existMunicipalityPort;
    private final InsertMunicipalityPort insertMunicipalityPort;
    private final UpdateMunicipalityPort updateMunicipalityPort;

    @Override
    public void downloadMunicipality() {

        try {

            List<Municipality> municipalities = downloadMunicipalityPort.downloadMunicipalities();

            for (Municipality municipality : municipalities) {

                if (existMunicipalityPort.existMunicipalityByMunicipalityCode(municipality.getMunicipalityCode())) {
                    municipality = updateMunicipalityPort.updateMunicipalityByMunicipalityCode(municipality);
                } else {
                    municipality = insertMunicipalityPort.insertMunicipality(municipality);
                }

            }

        } catch (MunicipalityPersistenceException municipalityPersistenceException) {
            log.debug(municipalityPersistenceException.getMessage());
            throw new DownloadMunicipalityException();
        }

    }
}
