package fr.orionbs.plot_manager.adapter.worker.municipality;

import fr.orionbs.plot_manager.application.port.input.DownloadMunicipalityUseCase;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MunicipalityWorkerAdapter {

    private final DownloadMunicipalityUseCase downloadMunicipalityUseCase;

    @PostConstruct
    public void downloadMunicipality() {
        downloadMunicipalityUseCase.downloadMunicipality();
    }

}
