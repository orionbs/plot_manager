package fr.orionbs.plot_manager.adapter.client.municipality.template;

import lombok.Data;

import java.util.List;

@Data
public class FieldsTemplate {
    private String code_postal;
    private String libelle_d_acheminement;
    private String code_commune_insee;
    private List<Double> coordonnees_geographiques;
    private String nom_de_la_commune;
}
