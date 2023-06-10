package fr.orionbs.plot_manager.adapter.persistence.plot.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "plot")
public class PlotEntity {

    @Id
    private String id;

    @Column(name = "creation")
    private Timestamp creation;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "municipality_code")
    private String municipalityCode;

    @Column(name = "section")
    private String section;

    @Column(name = "number")
    private String number;

    @Column(name = "prefix")
    private String prefix;

    @Column(name = "verify")
    private boolean verify;

    @OneToMany(mappedBy = "plot", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<CoordinateEntity> coordinates = new ArrayList<>();

}
