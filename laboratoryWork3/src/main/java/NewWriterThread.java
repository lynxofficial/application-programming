import java.util.Random;

public class NewWriterThread extends Thread implements Runnable {
    private Synchronizer synchronizer;

    public NewWriterThread(Synchronizer synchronizer) {
        this.synchronizer = synchronizer;
    }

    public void run() {
        Random random = new Random();
        for (int i = 0; i < synchronizer.getCollectionFilms().getNumberOfCollection().length; i++) {
            synchronizer.getCollectionFilms().getNumberOfCollection()[i] = random.nextInt(100) + 1;
            System.out.printf("Write: %d to position %d\n", synchronizer.getCollectionFilms()
                    .getNumberOfCollection()[i], i);
        }
    }
}
