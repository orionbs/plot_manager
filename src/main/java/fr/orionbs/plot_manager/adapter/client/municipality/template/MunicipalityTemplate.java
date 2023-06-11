package fr.orionbs.plot_manager.adapter.client.municipality.template;

import lombok.Data;

@Data
public class MunicipalityTemplate {
    private String datasetid;
    private String recordid;
    private FieldsTemplate fields;
    private GeometryTemplate geometry;
    private String record_timestamp;
}
