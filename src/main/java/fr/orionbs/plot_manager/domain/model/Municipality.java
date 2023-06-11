package fr.orionbs.plot_manager.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Municipality {
    private Integer id;
    private String recordId;
    private String dataSetId;
    private String postalCode;
    private String routingCode;
    private String municipalityCode;
    private Double longitude;
    private Double latitude;
    private String municipalityName;
    private LocalDateTime recordDateTime;
}
