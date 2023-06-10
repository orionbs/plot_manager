package fr.orionbs.plot_manager.adapter.persistence.plot.repository;

import fr.orionbs.plot_manager.adapter.persistence.plot.entity.CoordinateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinateRepository extends JpaRepository<CoordinateEntity, Integer> {
}
