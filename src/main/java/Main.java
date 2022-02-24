import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void addValues(int vectorLength, List<Double> doubles) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < vectorLength; i++) {
            doubles.add(scanner.nextDouble());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vectorLength = scanner.nextInt();
        List<Double> doubles = new ArrayList<>();
        addValues(vectorLength, doubles);
        Vector vector = new Vector(doubles, vectorLength);
        vector.sortDescending();
        vector.multiplyOnNumber(3);
        vector.getEuclideanNorm();
        addValues(vectorLength, doubles);
        Vector vector1 = new Vector(doubles, vectorLength);
        vector.addWithAnotherVector(vector1);
        vector.getScalarMultiply(vector1);
        vector.sortAscending();
        System.out.println(vector);
    }
}
