package com.sg.mowergame.service;


import com.sg.mowergame.data.Mower;

public interface IMowerService {
    /**
     * Allow to start mower game
     */
    void start();

    /**
     * Allow to mows the gason over a given area of lawn
     * @param mower
     * @param mowerOrientations
     * @param lawnPositionMaxX
     * @param lawnPositionMaxY
     * @return boolean true if the gason was sheared and faulse if not
     */
    boolean shearTheGason(Mower mower, String mowerOrientations, int lawnPositionMaxX, int lawnPositionMaxY);

    /**
     * Allow to draw the lawn
     * @param mower
     * @param lawnPositionMaxX
     * @param lawnPositionMaxY
     */
    void drawLawn(Mower mower, int lawnPositionMaxX, int lawnPositionMaxY);
}
