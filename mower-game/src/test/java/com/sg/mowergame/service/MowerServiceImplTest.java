package com.sg.mowergame.service;

import com.sg.mowergame.data.Mower;
import com.sg.mowergame.enumeration.OrientationEnum;
import com.sg.mowergame.service.console.ConsoleServiceImpl;
import com.sg.mowergame.service.console.IConsoleService;
import com.sg.mowergame.service.file.FileReaderServiceImpl;
import com.sg.mowergame.service.file.IFileReaderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MowerServiceImplTest {
    private IMowerService mowerService;
    private IConsoleService consoleService;
    private IFileReaderService fileReaderService;

    @BeforeEach
    void setUp() {
        this.consoleService = new ConsoleServiceImpl();
        this.fileReaderService = new FileReaderServiceImpl();
        this.mowerService = new MowerServiceImpl(consoleService, fileReaderService);
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void start() {
        mowerService.start();
    }

    @Test
    void givenValidInstructions_whenshearTheGason_ThenReturnsTrue() {
        // Given
        Mower mower = new Mower(1, 1, OrientationEnum.N);
        String instructions = "GDA";

        // When
        boolean result = mowerService.shearTheGason(mower, instructions, 5, 5);

        // Then
        assertTrue(result);
    }

    @Test
    void givenValidInput_whenDrawLawn_thenPrintsLawnWithMower() {
        // Given
        Mower mower = new Mower(1, 1, OrientationEnum.N);

        // When
        mowerService.drawLawn(mower, 5, 5);

        // Then
        // Manual verification needed for visual inspection on console
    }

}
