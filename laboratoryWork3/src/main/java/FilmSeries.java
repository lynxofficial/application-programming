import service.DefaultFilms;
import service.MaxSumException;
import service.MinSumException;

import java.util.Arrays;
import java.util.Objects;

public class FilmSeries implements DefaultFilms {
    private static final long[] DEFAULT_NUMBER_OF_SERIES = {1, 2, 3, 4, 5};
    private static final String DEFAULT_NAME_OF_SERIES = "Default name";
    private static final long DEFAULT_COST_OF_SERIES = 1000000L;

    private long[] numberOfSeries;
    private String nameOfSeries;
    private long costOfSeries;

    public FilmSeries() {
        this(DEFAULT_NUMBER_OF_SERIES, DEFAULT_NAME_OF_SERIES, DEFAULT_COST_OF_SERIES);
    }

    public FilmSeries(long[] numberOfSeries) {
        this(numberOfSeries, DEFAULT_NAME_OF_SERIES, DEFAULT_COST_OF_SERIES);
    }

    public FilmSeries(long[] numberOfSeries, String nameOfSeries) {
        this(numberOfSeries, nameOfSeries, DEFAULT_COST_OF_SERIES);
    }

    public FilmSeries(long[] numberOfSeries, String nameOfSeries, long costOfSeries) {
        this.numberOfSeries = numberOfSeries;
        this.nameOfSeries = nameOfSeries;
        this.costOfSeries = costOfSeries;
    }

    public long[] getNumberOfSeries() {
        return numberOfSeries;
    }

    public void setNumberOfSeries(long[] numberOfSeries) {
        this.numberOfSeries = numberOfSeries;
    }

    public String getNameOfSeries() {
        return nameOfSeries;
    }

    public void setNameOfSeries(String nameOfSeries) {
        this.nameOfSeries = nameOfSeries;
    }

    public long getCostOfSeries() {
        return costOfSeries;
    }

    public void setCostOfSeries(long costOfSeries) {
        this.costOfSeries = costOfSeries;
    }

    @Override
    public long sumOfElements() throws MaxSumException, MinSumException {
        if (Arrays.stream(numberOfSeries).sum() > 1000000) {
            throw new MaxSumException("This sum exceeds the!");
        } else if (Arrays.stream(numberOfSeries).sum() < 0) {
            throw new MinSumException("This sum smaller then zero!");
        }
        return Arrays.stream(numberOfSeries).sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FilmSeries that = (FilmSeries) o;
        return costOfSeries == that.costOfSeries
                && Arrays.equals(numberOfSeries, that.numberOfSeries)
                && Objects.equals(nameOfSeries, that.nameOfSeries);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(nameOfSeries, costOfSeries);
        result = 31 * result + Arrays.hashCode(numberOfSeries);
        return result;

    }

    @Override
    public String toString() {
        return "FilmSeries{" +
                "numberOfSeries=" + Arrays.toString(numberOfSeries) +
                ", nameOfSeries='" + nameOfSeries + '\'' +
                ", costOfSeries=" + costOfSeries +
                '}';
    }
}
