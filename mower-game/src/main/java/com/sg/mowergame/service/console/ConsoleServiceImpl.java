package com.sg.mowergame.service.console;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ConsoleServiceImpl implements IConsoleService {
    private final Scanner scanner;

    public ConsoleServiceImpl() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }

    @Override
    public void lineFeed() {
        System.out.println();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
