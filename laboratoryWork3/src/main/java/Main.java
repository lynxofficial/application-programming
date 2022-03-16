import service.DefaultFilms;
import service.MaxSumException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MaxSumException, IOException {
        Scanner scanner = new Scanner(System.in);
        List<DefaultFilms> defaultFilms = new ArrayList<>();
        FilmSeries.init();
        CollectionFilms.init();
        while (true) {
            System.out.println("Current list");
            for (int i = 0; i < defaultFilms.size(); i++)
                System.out.println("  " + defaultFilms.get(i));
            System.out.println("1. add FilmSeries");
            System.out.println("2. add CollectionFilms");
            System.out.println("3. save");
            System.out.println("4. load");
            System.out.println("0. Exit");
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            if (n == 1) {
                int number, cost;
                System.out.print("Enter number of series: ");
                number = scanner.nextInt();
                long[] s = new long[number];
                for (int i = 0; i < number; i++) {
                    System.out.print("Enter: ");
                    s[i] = scanner.nextInt();
                }
                String name;
                System.out.print("Enter name: ");
                name = scanner.next();
                System.out.print("Enter cost: ");
                cost = scanner.nextInt();
                FilmSeries filmSeries = new FilmSeries(s, name, cost);
                defaultFilms.add(filmSeries);
            }
            if (n == 2) {
                int number, cost;
                System.out.print("Enter number of collections: ");
                number = scanner.nextInt();
                long[] s = new long[number];
                for (int i = 0; i < number; i++) {
                    System.out.print("Enter: ");
                    s[i] = scanner.nextInt();
                }
                String name;
                System.out.print("Enter name: ");
                name = scanner.next();
                System.out.print("Enter cost: ");
                cost = scanner.nextInt();
                CollectionFilms collectionFilms = new CollectionFilms(s, name, cost);
                defaultFilms.add(collectionFilms);
            }
            String db_name = "db.txt";
            if (n == 3) {
                try {
                    PrintWriter printWriter = new PrintWriter(db_name);
                    printWriter.println(defaultFilms.size());
                    for (int i = 0; i < defaultFilms.size(); i++)
                        FilmsIO.write(defaultFilms.get(i), printWriter);
                    printWriter.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            if (n == 4) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(db_name));
                    int i, c;
                    c = Integer.parseInt(bufferedReader.readLine());
                    defaultFilms.clear();
                    for (i = 0; i < c; i++) {
                        DefaultFilms f = FilmsIO.read(bufferedReader);
                        defaultFilms.add(f);
                    }
                    bufferedReader.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        defaultFilms.get(0);
    }
}
