package fr.orionbs.plot_manager.adapter.persistence.municipality.repository;

import fr.orionbs.plot_manager.adapter.persistence.municipality.entity.MunicipalityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MunicipalityRepository extends JpaRepository<MunicipalityEntity, Integer> {
    Optional<MunicipalityEntity> findMunicipalityEntityByMunicipalityCodeIgnoreCase(String municipalityCode);
}