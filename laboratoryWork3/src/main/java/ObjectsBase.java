import service.DefaultFilms;

import java.util.Arrays;

public class ObjectsBase {
    private DefaultFilms[] defaultFilms;

    public DefaultFilms[] getDefaultFilms() {
        return defaultFilms;
    }

    public void setDefaultFilms(DefaultFilms[] defaultFilms) {
        this.defaultFilms = defaultFilms;
    }

    public void printInformation() {
        for (DefaultFilms defaultFilm : defaultFilms) {
            System.out.println(defaultFilm);
        }
    }

    public DefaultFilms[] findEqualObjects(CollectionFilms[] collectionFilms, FilmSeries[] filmSeries) {
        DefaultFilms[] defaultFilms = new DefaultFilms[(collectionFilms.length + filmSeries.length) * 2];
        for (int i = 0; i < Math.min(collectionFilms.length, filmSeries.length); i++) {
            if (collectionFilms[i].getCostOfCollection() == filmSeries[i].getCostOfSeries()) {
                defaultFilms[i] = collectionFilms[i];
                defaultFilms[i + 1] = filmSeries[i];
            }
        }
        return defaultFilms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ObjectsBase that = (ObjectsBase) o;
        return Arrays.equals(defaultFilms, that.defaultFilms);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(defaultFilms);
    }

    @Override
    public String toString() {
        return "ObjectsBase{" +
                "defaultFilms=" + Arrays.toString(defaultFilms) +
                '}';
    }
}

