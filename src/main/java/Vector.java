import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Vector {
    private static final long DEFAULT_VECTOR_LENGTH = 3;

    private List<Double> coordinates;
    private long vectorLength;

    public Vector(List<Double> coordinates) {
        this(coordinates, DEFAULT_VECTOR_LENGTH);
    }

    public Vector(List<Double> coordinates, long vectorLength) {
        this.coordinates = coordinates;
        this.vectorLength = vectorLength;
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public long getVectorLength() {
        return vectorLength;
    }

    public void setVectorLength(long vectorLength) {
        this.vectorLength = vectorLength;
    }

    public Double getMinValue() {
        return coordinates.stream().min(Double::compare).get();
    }

    public Double getMaxValue() {
        return coordinates.stream()
                .max(Double::compareTo)
                .get();
    }

    public void sortDescending() {
        coordinates = coordinates.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    public void sortAscending() {
        coordinates = coordinates.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public double getEuclideanNorm() {
        double s = 0;
        for (Double number : coordinates) {
            s += number * number;
        }
        return Math.sqrt(s);
    }

    public void multiplyOnNumber(long number) {
        for (int i = 0; i < vectorLength; i++) {
            coordinates.set(i, coordinates.get(i) * number);
        }
    }

    public void addWithAnotherVector(Vector vector) {
        for (int i = 0; i < vectorLength; i++) {
            coordinates.set(i, coordinates.get(i) + vector.getCoordinates().get(i));
        }
    }

    public double getScalarMultiply(Vector vector) {
        double s = 0;
        for (int i = 0; i < vectorLength; i++) {
            s += coordinates.get(i) * vector.getCoordinates().get(i);
        }
        return s;
    }
}
