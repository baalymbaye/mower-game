package com.sg.mowergame.service.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

public interface IFileReaderService {
    /**
     * Allow to read file
     * @param filePath
     * @return BufferedReader
     * @throws FileNotFoundException
     */
    BufferedReader readFile(String filePath) throws FileNotFoundException;
}
