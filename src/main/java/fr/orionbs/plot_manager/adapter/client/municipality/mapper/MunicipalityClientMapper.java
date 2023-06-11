package fr.orionbs.plot_manager.adapter.client.municipality.mapper;

import fr.orionbs.plot_manager.adapter.client.municipality.template.FieldsTemplate;
import fr.orionbs.plot_manager.adapter.client.municipality.template.GeometryTemplate;
import fr.orionbs.plot_manager.adapter.client.municipality.template.MunicipalityTemplate;
import fr.orionbs.plot_manager.domain.model.Municipality;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class MunicipalityClientMapper {
    public Municipality toMunicipality(MunicipalityTemplate municipalityTemplate) {
        Municipality municipality = new Municipality();

        municipality.setRecordId(municipalityTemplate.getRecordid());
        municipality.setDataSetId(municipalityTemplate.getDatasetid());
        municipality.setRecordDateTime(LocalDateTime.parse(municipalityTemplate.getRecord_timestamp(), DateTimeFormatter.ISO_DATE_TIME));

        if (municipalityTemplate.getFields() != null) {

            FieldsTemplate fieldsTemplate = municipalityTemplate.getFields();

            municipality.setPostalCode(fieldsTemplate.getCode_postal());
            municipality.setRoutingCode(fieldsTemplate.getLibelle_d_acheminement());
            municipality.setMunicipalityCode(fieldsTemplate.getCode_commune_insee());
            municipality.setMunicipalityName(fieldsTemplate.getNom_de_la_commune());

        }

        if (municipalityTemplate.getGeometry() != null && municipalityTemplate.getGeometry().getCoordinates() != null && !municipalityTemplate.getGeometry().getCoordinates().isEmpty()) {

            GeometryTemplate geometryTemplate = municipalityTemplate.getGeometry();

            municipality.setLongitude(geometryTemplate.getCoordinates().get(0));
            municipality.setLatitude(geometryTemplate.getCoordinates().get(1));

        }

        return municipality;
    }
}
