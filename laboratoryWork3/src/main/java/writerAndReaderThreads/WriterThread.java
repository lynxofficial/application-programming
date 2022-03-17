package writerAndReaderThreads;

import java.util.Random;

public class WriterThread extends Thread {
    private long[] numbers;

    public WriterThread(long[] numbers) {
        this.numbers = numbers;
    }

    public void run() {
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100) + 1;
            System.out.printf("Write: %d to position %d\n", numbers[i], i);
        }
    }
}
