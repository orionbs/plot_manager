package fr.orionbs.plot_manager.adapter.client.municipality.mapper;

import fr.orionbs.plot_manager.adapter.client.municipality.template.MunicipalityTemplate;
import fr.orionbs.plot_manager.domain.model.Municipality;
import org.springframework.stereotype.Component;

@Component
public class MunicipalityClientMapper {
    public Municipality toMunicipality(MunicipalityTemplate municipalityTemplate) {
        Municipality municipality = new Municipality();
        municipality.setMunicipalityCode(municipalityTemplate.getFields().getCode_commune_insee());
        return municipality;
    }
}
