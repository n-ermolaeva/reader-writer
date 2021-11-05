
public class MainClass {
    private static final int[][] myArray = {{1, 2, 3, 4, 5}, {11, 22, 33, 44, 55}, {11, 12, 13, 14, 15}};

    public static void main(String[] args) {
        Record record = new Record(myArray);
        new Writer(record);
        new Reader(record);
    }
}
