package fr.orionbs.plot_manager.adapter.api;

import fr.orionbs.plot_manager.application.port.input.DownloadMunicipalityUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DownloadMunicipalityApiAdapter {

    private final DownloadMunicipalityUseCase downloadMunicipalityUseCase;

    @GetMapping(path = "download-municipality")
    @ResponseStatus(code = HttpStatus.OK)
    public void downloadMunicipality() {
        downloadMunicipalityUseCase.downloadMunicipality();
    }

}
