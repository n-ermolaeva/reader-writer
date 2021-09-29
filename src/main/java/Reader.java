import java.util.Arrays;

public class Reader implements Runnable {
    private final int[][] array;
    public final Thread threadReader;

    public Reader(int[][] array) {
        this.array = array;
        threadReader = new Thread(this);
    }

    @Override
    public void run() {
        System.out.println(Arrays.deepToString(array));
    }
}
