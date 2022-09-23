package pl.kala.houseseekerdomain.database.model.document.house.enumeration;

import lombok.Getter;

@Getter
public enum HouseState {
    RENOVATED("odnowiony"),
    NEEDS_RENOVATION("wymaga remontu"),
    NEEDS_BIG_RENOVATION("do generalnego remontu")
    ;
    private final String label;

    HouseState(String label) {
        this.label = label;
    }
}
