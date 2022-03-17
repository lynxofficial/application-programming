public class NewReaderThread extends Thread implements Runnable {
    private Synchronizer synchronizer;

    public NewReaderThread(Synchronizer synchronizer) {
        this.synchronizer = synchronizer;
    }

    public Synchronizer getSynchronizer() {
        return synchronizer;
    }

    public void setSynchronizer(Synchronizer synchronizer) {
        this.synchronizer = synchronizer;
    }

    public void run() {
        for (int i = 0; i < synchronizer.getCollectionFilms().getNumberOfCollection().length; i++) {
            System.out.printf("Read: %d from position %d\n", synchronizer.getCollectionFilms()
                    .getNumberOfCollection()[i], i);
        }
    }
}
