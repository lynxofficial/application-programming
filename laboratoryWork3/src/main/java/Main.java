import writerAndReaderThreads.ReaderThread;
import writerAndReaderThreads.WriterThread;

public class Main {
    public static void main(String[] args) {
        CollectionFilms collectionFilms = new CollectionFilms();
        ReaderThread readerThread = new ReaderThread(collectionFilms.getNumberOfCollection());
        WriterThread writerThread = new WriterThread(collectionFilms.getNumberOfCollection());
        readerThread.setPriority(5);
        writerThread.setPriority(6);
        readerThread.start();
        writerThread.start();
        Synchronizer synchronizer = new Synchronizer(collectionFilms);
        NewReaderThread newReaderThread = new NewReaderThread(synchronizer);
        NewWriterThread newWriterThread = new NewWriterThread(synchronizer);
        newReaderThread.start();
        newWriterThread.start();
    }
}
