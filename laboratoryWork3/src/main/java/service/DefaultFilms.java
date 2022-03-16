package service;

import java.io.*;

public interface DefaultFilms {

    long sumOfElements() throws MaxSumException;

    void output(OutputStream out);

    void write(Writer out);

    void read(BufferedReader in);
}
