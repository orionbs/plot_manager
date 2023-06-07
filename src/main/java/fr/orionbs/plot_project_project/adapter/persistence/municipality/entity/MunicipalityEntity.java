package fr.orionbs.plot_project_project.adapter.persistence.municipality.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "municipality")
public class MunicipalityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "municipality_code", unique = true, updatable = false, length = 5)
    private String municipalityCode;

}
