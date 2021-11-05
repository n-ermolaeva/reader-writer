import java.util.Arrays;

public class Record {
    private int[][] myArray;

    public Record(int[][] myArray) {
        this.myArray = myArray;
    }

    public int[][] getMyArray() {
        return myArray;
    }

    public void setMyArray(int[][] myArray) {
        this.myArray = myArray;
    }

    public synchronized void write(int[][] myArray) {
        this.setMyArray(myArray);
        System.out.println("Писатель изменил массив " + Arrays.deepToString(this.getMyArray()));
    }

    public void read() {
        System.out.println("Читатель прочитал массив " + Arrays.deepToString(this.getMyArray()));
    }

}
