package mongkey.maeilmail.domain.enums;

import lombok.Getter;

@Getter
public enum CategoryType {
    FAIL("FAIL"),
    HELP("HELP"),
    RECOMMEND("RECOMMEND"),
    DAILY("DAILY");

    private final String categoryType;

    CategoryType(String categoryType){
        this.categoryType = categoryType;
    }
}
