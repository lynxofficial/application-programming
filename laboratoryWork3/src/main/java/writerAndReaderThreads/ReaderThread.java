package writerAndReaderThreads;

public class ReaderThread extends Thread {
    private long[] numbers;

    public ReaderThread(long[] numbers) {
        this.numbers = numbers;
    }

    public void run() {
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("Read: %d from position %d\n", numbers[i], i);
        }
    }
}
