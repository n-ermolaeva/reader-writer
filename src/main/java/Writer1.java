
public class Writer1 implements Runnable {
    private final int[][] array;
    public final Thread threadWriter1;

    public Writer1(int[][] array) {
        this.array = array;
        threadWriter1 = new Thread(this);
    }

    @Override
    public void run() {
        synchronized (array) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j] % 2 == 0) array[i][j] *= 2;
                }
            }
        }
    }
}
