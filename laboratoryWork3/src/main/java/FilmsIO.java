import service.DefaultFilms;

import java.io.*;

public class FilmsIO {
    static void output(DefaultFilms o, OutputStream out) {
        o.output(out);
    }

    static DefaultFilms input(InputStream in) throws IOException {
        return null;
    }

    static void write(DefaultFilms o, Writer out) {
        o.write(out);
    }

    static DefaultFilms read(BufferedReader rd) throws IOException {
        DefaultFilms defaultFilms;
        String s = rd.readLine();
        int clsid = Integer.parseInt(s);
        defaultFilms = Factory.create(clsid);
        defaultFilms.read(rd);
        return defaultFilms;
    }
}
