package com.mahadi.demo.enumeration;

public enum MonitorRequrement {
	WithMonitor("With Monitor"),
	WithoutMonitor("Without Monitor");

    private final String displayName;

    MonitorRequrement(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
