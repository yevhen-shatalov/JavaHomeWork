package com.pb.shatalov.hw7;

public enum Size {
    XXS("XXS", 32),
    XS("XS", 34),
    S("S", 36),
    M("M", 38),
    L("L", 40);



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
