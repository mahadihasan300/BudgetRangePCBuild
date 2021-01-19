package com.mahadi.demo.enumeration;

public enum Budget {
	ThertyThousand("Therty Thousand"),
	FifryThousand("Fifty Thousand");

    private final String displayName;

    Budget(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
