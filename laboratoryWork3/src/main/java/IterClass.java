import service.DefaultFilms;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class IterClass implements Iterable {
    private List<DefaultFilms> defaultFilms;

    public IterClass(List<DefaultFilms> defaultFilms) {
        this.defaultFilms = defaultFilms;
    }

    @Override
    public Iterator iterator() {
        return defaultFilms.iterator();
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }
}
