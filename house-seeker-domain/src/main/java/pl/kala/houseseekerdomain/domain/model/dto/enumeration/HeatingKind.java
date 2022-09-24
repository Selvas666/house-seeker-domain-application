package pl.kala.houseseekerdomain.domain.model.dto.enumeration;

import lombok.Getter;

@Getter
public enum HeatingKind {
    GAS_HEATING("piec gazowy"),
    SOLID_FUEL_HEATING("opał paliwem stałym"),
    CENTRAL_HEATING("centralne ogrzewanie"),
    OTHER ("inne");

    private final String label;

    HeatingKind(String label) {
        this.label = label;
    }
}
