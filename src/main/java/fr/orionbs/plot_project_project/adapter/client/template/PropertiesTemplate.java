package fr.orionbs.plot_project_project.adapter.client.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertiesTemplate {

    private String id;
    private String created;
    private String updated;
    private String commune;
    private String numero;
    private String prefixe;
    private String contenance;
    private String arpente;
    private String section;

}
