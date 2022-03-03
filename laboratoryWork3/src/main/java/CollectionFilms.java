import service.DefaultFilms;
import service.MaxSumException;
import service.MinSumException;

import java.util.Arrays;
import java.util.Objects;

public class CollectionFilms implements DefaultFilms {
    private static final long[] DEFAULT_NUMBER_OF_COLLECTION = {8, 4, 1, 5};
    private static final String DEFAULT_NAME_OF_COLLECTION = "Name";
    private static final long DEFAULT_COST_OF_COLLECTION = 1000;

    private long[] numberOfCollection;
    private String nameOfCollection;
    private long costOfCollection;

    public CollectionFilms() {
        this(DEFAULT_NUMBER_OF_COLLECTION, DEFAULT_NAME_OF_COLLECTION, DEFAULT_COST_OF_COLLECTION);
    }

    public CollectionFilms(long[] numberOfCollection) {
        this(numberOfCollection, DEFAULT_NAME_OF_COLLECTION, DEFAULT_COST_OF_COLLECTION);
    }

    public CollectionFilms(long[] numberOfCollection, String nameOfCollection) {
        this(numberOfCollection, nameOfCollection, DEFAULT_COST_OF_COLLECTION);
    }

    public CollectionFilms(long[] numberOfCollection, String nameOfCollection, long costOfCollection) {
        this.numberOfCollection = numberOfCollection;
        this.nameOfCollection = nameOfCollection;
        this.costOfCollection = costOfCollection;
    }

    public long[] getNumberOfCollection() {
        return numberOfCollection;
    }

    public void setNumberOfCollection(long[] numberOfCollection) {
        this.numberOfCollection = numberOfCollection;
    }

    public String getNameOfCollection() {
        return nameOfCollection;
    }

    public void setNameOfCollection(String nameOfCollection) {
        this.nameOfCollection = nameOfCollection;
    }

    public long getCostOfCollection() {
        return costOfCollection;
    }

    public void setCostOfCollection(long costOfCollection) {
        this.costOfCollection = costOfCollection;
    }

    @Override
    public long sumOfElements() throws MaxSumException, MinSumException {
        if (Arrays.stream(numberOfCollection).sum() > 10000000) {
            System.out.println("This sum exceeds the!");
        } else if (Arrays.stream(numberOfCollection).sum() < 0) {
            System.out.println("This sum is smaller then zero!");
        }
        return Arrays.stream(numberOfCollection).sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CollectionFilms that = (CollectionFilms) o;
        return costOfCollection == that.costOfCollection
                && Arrays.equals(numberOfCollection, that.numberOfCollection)
                && Objects.equals(nameOfCollection, that.nameOfCollection);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(nameOfCollection, costOfCollection);
        result = 31 * result + Arrays.hashCode(numberOfCollection);
        return result;
    }

    @Override
    public String toString() {
        return "CollectionFilms{" +
                "numberOfCollection=" + Arrays.toString(numberOfCollection) +
                ", nameOfCollection='" + nameOfCollection + '\'' +
                ", costOfCollection=" + costOfCollection +
                '}';
    }
}
