package fr.orionbs.plot_manager.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Municipality {
    private String municipalityCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Municipality that = (Municipality) o;
        return Objects.equals(municipalityCode, that.municipalityCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(municipalityCode);
    }
}
