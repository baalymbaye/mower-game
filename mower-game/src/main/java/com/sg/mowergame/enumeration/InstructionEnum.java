package com.sg.mowergame.enumeration;

public enum InstructionEnum {
    G, D, A;

    public static InstructionEnum fromChar(char instructionChar) {
        return switch (Character.toUpperCase(instructionChar)) {
            case 'G' -> InstructionEnum.G;
            case 'D' -> InstructionEnum.D;
            case 'A' -> InstructionEnum.A;
            default -> throw new IllegalArgumentException("Instruction non valide : " + instructionChar);
        };
    }
}
