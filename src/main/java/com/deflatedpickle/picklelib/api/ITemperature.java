package com.deflatedpickle.picklelib.api;

public interface ITemperature {
    default boolean hasTemperature() {
        return true;
    }

    default boolean isHot() {
        return getTemperature() > 38;
    }

    default boolean isMid() {
        return getTemperature() > 21 && getTemperature() < 38;
    }

    default boolean isCold() {
        return getTemperature() < 21;
    }

    int getTemperature();
}
