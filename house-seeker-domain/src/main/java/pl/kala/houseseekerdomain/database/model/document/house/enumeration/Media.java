package pl.kala.houseseekerdomain.database.model.document.house.enumeration;

import lombok.Getter;

@Getter
public enum Media {
    ELECTRICITY("elektryczność"),
    WATER("woda"),
    SEWAGE("ścieki"),
    CESSPOOL("szambo"),
    GAS("gaz"),
    TELEPHONE("linia telefoniczna"),
    FIBER_INTERNET("światłowód")
    ;
    private final String label;

    Media(String label) {
        this.label = label;
    }
}
