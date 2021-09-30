
public class MainClass {
    final static private int[][] myArray = {{1, 2, 3, 4, 5}, {11, 22, 33, 44, 55}, {11, 12, 13, 14, 15}};

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {

            Reader reader = new Reader(myArray);
            reader.threadReader.start();

            Writer writer1 = new Writer(myArray);
            writer1.threadWriter.start();

            Writer writer = new Writer(myArray);
            writer.threadWriter.start();

            Reader reader1 = new Reader(myArray);
            reader1.threadReader.start();

            if (reader.threadReader.isAlive() || reader1.threadReader.isAlive()) {
                synchronized (myArray) {
                    waitThread(reader,reader1);
                }
            }
        }
    }

    private static void waitThread(Reader... readers) {
        for (Reader reader : readers) {
            try {
                reader.threadReader.join();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }
}
