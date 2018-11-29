package com.codecool.bbbt.huntapped.backend.model;

public enum Type {
    IPA("IPA"),
    STOUT("Stout"),
    LAGER("Lager"),
    WHEAT("Wheat beer"),
    IMPERIAL_STOUT("Imperial Stout"),
    IMPERIAL_IPA("Imperial IPA");

    private final String style;

    private Type(String style) {
        this.style = style;
    }
}
