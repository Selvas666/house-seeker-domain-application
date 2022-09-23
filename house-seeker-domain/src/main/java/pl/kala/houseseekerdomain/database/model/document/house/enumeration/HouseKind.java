package pl.kala.houseseekerdomain.database.model.document.house.enumeration;

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
