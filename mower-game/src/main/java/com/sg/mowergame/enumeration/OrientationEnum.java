package com.sg.mowergame.enumeration;

public enum OrientationEnum {
    N, E, W, S;

    public static OrientationEnum fromString(String orientationStr) {
        return switch (orientationStr.toUpperCase()) {
            case "N" -> OrientationEnum.N;
            case "E" -> OrientationEnum.E;
            case "W" -> OrientationEnum.W;
            case "S" -> OrientationEnum.S;
            default -> throw new IllegalArgumentException("Wrong orientation : " + orientationStr);
        };
    }
}
