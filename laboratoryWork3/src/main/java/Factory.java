import service.DefaultFilms;

import java.util.ArrayList;
import java.util.List;

public class Factory {
    private static List<Factory> factories;

    private int clsId;
    private Synchronizer synchronizer;

    public Factory(int id) {
        this.clsId = id;
        if (factories == null)
            factories = new ArrayList<>();
        factories.add(this);
    }

    public DefaultFilms createClass() {
        return null;
    }

    public int getClsId() {
        return clsId;
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
            if (factories.get(i).getClsId() == id)
                return factories.get(i).createClass();
        return null;
    }
}
