package fr.orionbs.plot_manager.adapter.persistence.municipality.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "municipality")
public class MunicipalityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "municipality_code", unique = true)
    private String municipalityCode;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

}
