package pl.kala.houseseekerdomain.housedomain.database.model.document.locality.enumeration;

import lombok.Getter;

@Getter
public enum Voivodship {
    LOWER_SILESIAN("Dolnośląskie"),
    GREATER_POLAND("Wielkopolskie"),
    OPOLE("Opolskie")
    ;
    private final String label;

    Voivodship(String label) {
        this.label = label;
    }
}
