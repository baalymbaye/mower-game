package com.sg.mowergame.data;


import com.sg.mowergame.enumeration.OrientationEnum;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Mower {
    private int positionX;
    private int positionY;
    private OrientationEnum orientation;

    //    public int getPositionX() {
//        return positionX;
//    }
//
//    public void setPositionX(int positionX) {
//        this.positionX = positionX;
//    }
//
//    public int getPositionY() {
//        return positionY;
//    }
//
//    public void setPositionY(int positionY) {
//        this.positionY = positionY;
//    }
//
//    public OrientationEnum getMowerOrientationEnum() {
//        return orientation;
//    }
//
//    public void setMowerOrientationEnum(OrientationEnum orientationEnum) {
//        this.orientation = orientationEnum;
//    }

    /**
     * Allow to move toward the next square
     */
    public void moveTowards() {
        switch (this.orientation) {
            case N -> positionY++;
            case E -> positionX++;
            case W -> positionX--;
            case S -> positionY--;
        }
    }

    /**
     * Turns the mower 90° to the right without moving it
     */
    public void turnRight() {
        this.orientation = switch (this.orientation) {
            case N -> OrientationEnum.E;
            case E -> OrientationEnum.S;
            case W -> OrientationEnum.N;
            case S -> OrientationEnum.W;
        };
    }

    /**
     * Turns the mower 90° to the left without moving it
     */
    public void turnLeft() {
        this.orientation = switch (this.orientation) {
            case N -> OrientationEnum.W;
            case E -> OrientationEnum.N;
            case W -> OrientationEnum.S;
            case S -> OrientationEnum.E;
        };
    }

    /**
     * Return mower position on lawn
     * @return
     */
    public String getPosition() {
        return positionX + " " + positionY + " " + this.orientation;
    }

}
