public class Synchronizer {
    private CollectionFilms collectionFilms;
    private volatile int current = 0;
    private Object lock = new Object();
    private boolean flag = false;

    public CollectionFilms getCollectionFilms() {
        return collectionFilms;
    }

    public void setCollectionFilms(CollectionFilms collectionFilms) {
        this.collectionFilms = collectionFilms;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public Object getLock() {
        return lock;
    }

    public void setLock(Object lock) {
        this.lock = lock;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Synchronizer(CollectionFilms collectionFilms) {
        this.collectionFilms = collectionFilms;
    }

    public double read() throws InterruptedException {
        double val;
        synchronized (lock) {
            if (!canRead()) {
                throw new InterruptedException();
            }
            while (!flag) {
                lock.wait();
            }
            val = current++;
            System.out.println("Read: " + val);
            flag = false;
            lock.notifyAll();
        }
        return val;
    }

    public void write(long val) throws InterruptedException {
        synchronized (lock) {
            if (!canWrite()) {
                throw new InterruptedException();
            }
            while (flag) {
                lock.wait();
            }
            for (int i = 0; i < collectionFilms.getNumberOfCollection().length; i++) {
                collectionFilms.setCostOfCollection(val);
            }
            System.out.println("Write: " + val);
            flag = true;
            lock.notifyAll();
        }
    }

    public boolean canRead() {
        return current < collectionFilms.getNumberOfCollection().length;
    }

    public boolean canWrite() {
        return (!flag && current < collectionFilms.getNumberOfCollection().length)
                || (flag && current < collectionFilms.getNumberOfCollection().length - 1);
    }
}
