package com.sg.mowergame.service.file;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Service
public class FileReaderServiceImpl implements IFileReaderService {
    @Override
    public BufferedReader readFile(String filePath) throws FileNotFoundException {
        return new BufferedReader(new FileReader(filePath));
    }
}
