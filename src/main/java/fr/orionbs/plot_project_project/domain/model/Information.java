package fr.orionbs.plot_project_project.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information {

    private String postalCode;
    private String municipalityCode;
    private String section;
    private String number;
    private String prefix;
    private Boolean check;


}
