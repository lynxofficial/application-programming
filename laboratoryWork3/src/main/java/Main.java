import service.DefaultFilms;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CollectionFilms collectionFilms = new CollectionFilms();
        CollectionFilms collectionFilms1 = new CollectionFilms(new long[]{1, 3, 5, 105, 4391});
        FilmSeries filmSeries = new FilmSeries();
        List<DefaultFilms> defaultFilms = new ArrayList<>();
        defaultFilms.add(collectionFilms);
        defaultFilms.add(collectionFilms1);
        defaultFilms.add(filmSeries);
        for (DefaultFilms newDefaultFilms : defaultFilms) {
            System.out.println(newDefaultFilms);
        }
    }
}
