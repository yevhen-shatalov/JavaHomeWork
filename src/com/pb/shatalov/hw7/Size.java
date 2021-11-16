package com.pb.shatalov.hw7;

public enum Size {
    XXS("детский", 32),
    XS("взрослый", 34),
    S("взрослый", 36),
    M("взрослый", 38),
    L("взрослый", 40);



    private String description;
    private int euroSize;

    Size(String description, int euroSize) {
        this.description = description;
        this.euroSize = euroSize;
    }

    private String getDescription() {
        return description;
        }
    private int getEuroSize() {
        return euroSize;
    }
}
