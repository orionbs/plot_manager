package fr.orionbs.plot_manager.adapter.persistence.municipality.mapper;

import fr.orionbs.plot_manager.adapter.persistence.municipality.entity.MunicipalityEntity;
import fr.orionbs.plot_manager.domain.model.Municipality;
import org.springframework.stereotype.Component;

@Component
public class MunicipalityPersistenceMapper {
    public Municipality toMunicipality(MunicipalityEntity municipalityEntity) {
        Municipality municipality = new Municipality();
        municipality.setId(municipalityEntity.getId());
        municipality.setMunicipalityName(municipalityEntity.getName());
        municipality.setMunicipalityCode(municipalityEntity.getMunicipalityCode());
        municipality.setPostalCode(municipalityEntity.getPostalCode());
        municipality.setLongitude(municipalityEntity.getLongitude());
        municipality.setLatitude(municipalityEntity.getLatitude());
        return municipality;
    }
}
