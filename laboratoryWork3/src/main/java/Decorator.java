import service.DefaultFilms;
import service.MaxSumException;

import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.Writer;

public class Decorator implements DefaultFilms {
    private DefaultFilms defaultFilms;

    @Override
    public long sumOfElements() throws MaxSumException {
        return defaultFilms.sumOfElements();
    }

    @Override
    public void output(OutputStream out) {
        defaultFilms.output(out);
    }

    public DefaultFilms getDefaultFilms() {
        return defaultFilms;
    }

    public void setDefaultFilms(DefaultFilms defaultFilms) {
        this.defaultFilms = defaultFilms;
        throw new UnsupportedOperationException();
    }

    @Override
    public void write(Writer out) {
        defaultFilms.write(out);
    }

    @Override
    public void read(BufferedReader in) {
        defaultFilms.read(in);
    }
}
