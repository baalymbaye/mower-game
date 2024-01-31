package com.sg.mowergame.service;

import com.sg.mowergame.data.Mower;
import com.sg.mowergame.enumeration.InstructionEnum;
import com.sg.mowergame.enumeration.OrientationEnum;
import com.sg.mowergame.service.console.IConsoleService;
import com.sg.mowergame.service.file.IFileReaderService;
import com.sg.mowergame.util.LawnUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class MowerServiceImpl implements IMowerService {
    private static final String TEST_FILE_PATH = "src/test/resources/";

    private final IConsoleService consoleService;
    private final IFileReaderService fileReaderService;

    @Autowired
    public MowerServiceImpl(IConsoleService consoleService, IFileReaderService fileReaderService) {
        this.consoleService = consoleService;
        this.fileReaderService = fileReaderService;
    }

    @Override
    public void start() {
        int numberMower = 1;

        consoleService.write("**************************************");
        consoleService.write("*             Mower Game             *");
        consoleService.write("**************************************");
        consoleService.write("Please enter the path and name of the input file : ");
//        String filePath = consoleService.read();
//        filePath = TEST_FILE_PATH + filePath;

//         :: Test case passing
        String filePath = TEST_FILE_PATH + "mower-game-input.txt";
//        String filePath = TEST_FILE_PATH + "mower-game-input-2.txt";

//         :: Non passing test case
//        String filePath = TEST_FILE_PATH + "mower-game-nullPointerException.txt";
//        String filePath = TEST_FILE_PATH + "mower-game-file-not-exist.merguez";

        Mower mower = new Mower(0, 0, OrientationEnum.N);
        int lawnPositionMaxX = 0;
        int lawnPositionMaxY = 0;

        try (BufferedReader reader = fileReaderService.readFile(filePath)) {
            String lawnCoordinate = reader.readLine();
            String[] lawnCoordinates = lawnCoordinate.split(" ");
            lawnPositionMaxX = Integer.parseInt(lawnCoordinates[0]);
            lawnPositionMaxY = Integer.parseInt(lawnCoordinates[1]);

            while (reader.ready()) {
                String mowerPosition = reader.readLine();
                String[] mowerPositions = mowerPosition.split(" ");

                String mowerOrientations = reader.readLine();

                if (mowerPositions.length > 0) {

                    consoleService.write("**************************************");
                    consoleService.write("***           Mower N° : " + numberMower +"         ***");
                    mower = new Mower(Integer.parseInt(mowerPositions[0]), Integer.parseInt(mowerPositions[1]), OrientationEnum.fromString(mowerPositions[2]));

                    consoleService.write("Initial lawn condition.");
                    this.drawLawn(mower, lawnPositionMaxX, lawnPositionMaxY);

                    this.shearTheGason(mower, mowerOrientations, lawnPositionMaxX, lawnPositionMaxY);

                    consoleService.write("Final lawn condition.");
                    this.drawLawn(mower, lawnPositionMaxX, lawnPositionMaxY);

                    consoleService.write("Result : " + mower.getPosition());
                    consoleService.write("**************************************");
                    consoleService.lineFeed();
                    numberMower++;
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            consoleService.write("The input file does not exist. File : " + fileNotFoundException.getMessage());
        } catch (NullPointerException | IOException exception) {
            consoleService.write("Error reading input file : Please check." + exception.getMessage());
        } finally {
            consoleService.write("    N    ");
            consoleService.write("W   +   E");
            consoleService.write("    S    ");

            consoleService.close();
        }
    }

    @Override
    public boolean shearTheGason(Mower mower, String mowerOrientations, int lawnPositionMaxX, int lawnPositionMaxY) {
        boolean isGasonSheared = false;

        for (char instruction : mowerOrientations.toCharArray()) {
            InstructionEnum instructionEnum = InstructionEnum.fromChar(instruction);

            switch (instructionEnum) {
                case G -> mower.turnLeft();
                case D -> mower.turnRight();
                case A -> {
                    // Historise mower position
                    Mower oldMower = new Mower(mower.getPositionX(), mower.getPositionY(), mower.getOrientation());
                    oldMower.moveTowards();

                    // Advance only if the new position (oldMower + move) is inside the pitch
                    if (0 <= oldMower.getPositionX() && oldMower.getPositionX() <= lawnPositionMaxX
                            && 0 <= oldMower.getPositionY() && oldMower.getPositionY() <= lawnPositionMaxY) {
                        mower.moveTowards();
                    }
                }
                default -> {
                }
            }

            isGasonSheared = true;
        }

        return isGasonSheared;
    }

    @Override
    public void drawLawn(Mower mower, int lawnPositionMaxX, int lawnPositionMaxY) {
        drawHorizontalLine(lawnPositionMaxX);

        for (int line = 1; line < lawnPositionMaxX+1; line++) {
            System.out.print(LawnUtils.SEPARATOR);

            for (int column = 1; column < lawnPositionMaxY+1; column++) {
                if (mower.getPositionX() == line && mower.getPositionY() == column) {
                    System.out.print(LawnUtils.SPACE + mower.getOrientation().toString() + LawnUtils.SPACE); // Espace entre les cases
                } else {
                    System.out.print("   ");
                }
                System.out.print(LawnUtils.SEPARATOR);
            }

            System.out.println();
            drawHorizontalLine(lawnPositionMaxX);
        }


        System.out.println("");
    }

    private void drawHorizontalLine(int lawnPositionMaxX) {
        for (int i = 0; i < lawnPositionMaxX*2; i++) {
            System.out.print(LawnUtils.SEPARATOR + LawnUtils.SPACE);
        }
        // Draw a horizontal line
        System.out.println(LawnUtils.SEPARATOR);
    }
}
