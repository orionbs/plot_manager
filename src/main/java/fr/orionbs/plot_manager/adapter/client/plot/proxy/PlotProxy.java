package fr.orionbs.plot_manager.adapter.client.plot.proxy;

import fr.orionbs.plot_manager.adapter.client.plot.template.FeatureCollectionTemplate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "plot-proxy", url = "https://cadastre.data.gouv.fr/bundler/cadastre-etalab")
public interface PlotProxy {

    @GetMapping(path = "/communes/{municipalityCode}/geojson/parcelles", produces = MediaType.APPLICATION_JSON_VALUE)
    FeatureCollectionTemplate getPlotOfOneMunicipality(@PathVariable String municipalityCode);

}
