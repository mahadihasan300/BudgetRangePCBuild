package com.mahadi.demo.enumeration;

public enum Purpose {
	Gaming("Gaming"),
	Editing("Editing"),
	Both("Both");

    private final String displayName;

    Purpose(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
