package fr.orionbs.plot_project_project.adapter.persistence.municipality.mapper;

import fr.orionbs.plot_project_project.adapter.persistence.municipality.entity.MunicipalityEntity;
import fr.orionbs.plot_project_project.domain.model.Municipality;
import org.springframework.stereotype.Component;

@Component
public class MunicipalityMapper {

    public Municipality toMunicipality(MunicipalityEntity municipalityEntity) {
        Municipality municipality = new Municipality();
        municipality.setMunicipalityCode(municipalityEntity.getMunicipalityCode());
        return municipality;
    }

}
