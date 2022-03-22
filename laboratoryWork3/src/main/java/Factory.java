import service.DefaultFactory;
import service.DefaultFilms;

import java.util.ArrayList;
import java.util.List;

public class Factory implements DefaultFactory {
    private static List<Factory> factories;

    private int classId;
    private Synchronizer synchronizer;

    public Factory(int id) {
        this.classId = id;
        if (factories == null)
            factories = new ArrayList<>();
        factories.add(this);
    }

    @Override
    public DefaultFilms createInstance() {
        return new CollectionFilms();
    }

    public int getClassId() {
        return classId;
    }

    public Synchronizer getSynchronizer() {
        return synchronizer;
    }

    public void setSynchronizer(Synchronizer synchronizer) {
        this.synchronizer = synchronizer;
    }

    public static DefaultFilms create(int id) {
        if (factories == null)
            return null;
        for (int i = 0; i < factories.size(); i++)
            if (factories.get(i).getClassId() == id)
                return factories.get(i).createInstance();
        return null;
    }

    public static DefaultFilms unmodifiable(DefaultFilms defaultFilms) {
        return defaultFilms;
    }
}
