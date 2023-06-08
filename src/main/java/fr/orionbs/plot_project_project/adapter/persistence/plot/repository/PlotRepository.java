package fr.orionbs.plot_project_project.adapter.persistence.plot.repository;

import fr.orionbs.plot_project_project.adapter.persistence.plot.entity.PlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlotRepository extends JpaRepository<PlotEntity, String> {
}
