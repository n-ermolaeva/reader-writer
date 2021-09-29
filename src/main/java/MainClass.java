
public class MainClass {
    final static private int[][] myArray = {{1, 2, 3, 4, 5}, {11, 22, 33, 44, 55}, {11, 12, 13, 14, 15}};

    public static void main(String[] args) {
        Reader reader1 = new Reader(myArray);
        Reader reader2 = new Reader(myArray);
        Reader reader3 = new Reader(myArray);

        Writer1 writer11 = new Writer1(myArray);
        Writer1 writer12 = new Writer1(myArray);

        Writer2 writer21 = new Writer2(myArray);
        Writer2 writer22 = new Writer2(myArray);

        reader1.threadReader.start();
        reader2.threadReader.start();

        writer11.threadWriter1.start();
        waitThreadReader(reader1, reader2, reader3);

        writer12.threadWriter1.start();
        waitThreadReader(reader1, reader2, reader3);

        reader3.threadReader.start();

        writer21.threadWriter2.start();
        waitThreadReader(reader1, reader2, reader3);

        writer22.threadWriter2.start();
        waitThreadReader(reader1, reader2, reader3);
    }

    private static void waitThreadReader(Reader... readers) {
        for (Reader reader : readers) {
            try {
                reader.threadReader.join();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }
}
