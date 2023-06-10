package fr.orionbs.plot_manager.adapter.persistence.plot.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "coordinate")
public class CoordinateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @ManyToOne
    @JoinColumn(name = "plot_id", referencedColumnName = "id")
    private PlotEntity plot;

}
