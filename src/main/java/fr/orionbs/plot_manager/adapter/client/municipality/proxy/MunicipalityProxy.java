package fr.orionbs.plot_manager.adapter.client.municipality.proxy;

import fr.orionbs.plot_manager.adapter.client.municipality.template.MunicipalityTemplate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "municipality-proxy", url = "https://www.data.gouv.fr/fr/datasets/r")
public interface MunicipalityProxy {

    @GetMapping(path = "/f60e05fb-b650-4c8a-80bd-03c4c08f623b", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MunicipalityTemplate> getAllMunicipalityOfFrance();

}
