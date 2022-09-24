package pl.kala.houseseekerdomain.domain.model.dto.enumeration;

import lombok.Getter;

@Getter
public enum HouseKind {
    APARTMENT("mieszkanie"),
    HOUSE("dom wolnostojący"),
    CONDO("szeregówka/bliźniak")
    ;
    private final String label;

    HouseKind(String label) {
        this.label = label;
    }
}
