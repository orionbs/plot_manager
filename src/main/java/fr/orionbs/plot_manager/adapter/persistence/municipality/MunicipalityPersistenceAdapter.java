package fr.orionbs.plot_manager.adapter.persistence.municipality;

import fr.orionbs.plot_manager.adapter.persistence.municipality.entity.MunicipalityEntity;
import fr.orionbs.plot_manager.adapter.persistence.municipality.exception.MunicipalityPersistenceException;
import fr.orionbs.plot_manager.adapter.persistence.municipality.mapper.MunicipalityPersistenceMapper;
import fr.orionbs.plot_manager.adapter.persistence.municipality.repository.MunicipalityRepository;
import fr.orionbs.plot_manager.application.port.output.ExistMunicipalityPort;
import fr.orionbs.plot_manager.application.port.output.InsertMunicipalityPort;
import fr.orionbs.plot_manager.application.port.output.UpdateMunicipalityPort;
import fr.orionbs.plot_manager.domain.model.Municipality;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class MunicipalityPersistenceAdapter implements InsertMunicipalityPort, UpdateMunicipalityPort, ExistMunicipalityPort {

    private final MunicipalityRepository municipalityRepository;
    private final MunicipalityPersistenceMapper municipalityPersistenceMapper;

    @Override
    public Boolean existMunicipalityByPostalCode(String postalCode) {
        return municipalityRepository.existsMunicipalityEntityByPostalCodeIgnoreCase(postalCode);
    }

    @Override
    public Boolean existMunicipalityByMunicipalityCode(String municipalityCode) {
        return municipalityRepository.existsMunicipalityEntityByMunicipalityCodeIgnoreCase(municipalityCode);
    }

    @Override
    @Transactional
    public Municipality insertMunicipality(Municipality municipality) throws MunicipalityPersistenceException {

        try {

            MunicipalityEntity municipalityEntity = new MunicipalityEntity();
            municipalityEntity.setName(municipality.getMunicipalityName());
            municipalityEntity.setMunicipalityCode(municipality.getMunicipalityCode());
            municipalityEntity.setPostalCode(municipality.getPostalCode());
            municipalityEntity.setLongitude(municipality.getLongitude());
            municipalityEntity.setLatitude(municipality.getLatitude());
            municipalityEntity = municipalityRepository.save(municipalityEntity);
            log.debug("Municipality insertion, id: " + municipalityEntity.getId());
            return municipalityPersistenceMapper.toMunicipality(municipalityEntity);

        } catch (Exception exception) {
            throw new MunicipalityPersistenceException(exception.getMessage(), exception.getCause());
        }

    }

    @Override
    @Transactional
    public Municipality updateMunicipalityByMunicipalityCode(Municipality municipality) throws MunicipalityPersistenceException {

        try {

            MunicipalityEntity municipalityEntity = municipalityRepository.findMunicipalityEntityByMunicipalityCodeIgnoreCase(municipality.getMunicipalityCode())
                    .orElseThrow(() -> new RuntimeException("Unknown municipality."));

            if (municipality.getMunicipalityName() != null && !municipality.getMunicipalityName().equalsIgnoreCase(municipalityEntity.getName())) {
                municipalityEntity.setName(municipality.getMunicipalityName());
            }

            if (municipality.getMunicipalityCode() != null && !municipality.getMunicipalityCode().equalsIgnoreCase(municipalityEntity.getMunicipalityCode())) {
                municipalityEntity.setMunicipalityCode(municipality.getMunicipalityCode());
            }

            if (municipality.getPostalCode() != null && !municipality.getPostalCode().equalsIgnoreCase(municipalityEntity.getPostalCode())) {
                municipalityEntity.setPostalCode(municipality.getPostalCode());
            }

            if (municipality.getLongitude() != null && !municipality.getLongitude().equals(municipalityEntity.getLongitude())) {
                municipalityEntity.setLongitude(municipality.getLongitude());
            }

            if (municipality.getLatitude() != null && !municipality.getLatitude().equals(municipalityEntity.getLatitude())) {
                municipalityEntity.setLatitude(municipality.getLatitude());
            }

            municipalityEntity = municipalityRepository.save(municipalityEntity);
            log.debug("Municipality update, id: " + municipalityEntity.getId());

            return municipalityPersistenceMapper.toMunicipality(municipalityEntity);

        } catch (Exception exception) {
            throw new MunicipalityPersistenceException(exception.getMessage(), exception.getCause());
        }

    }
}
