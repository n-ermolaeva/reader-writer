
public class Writer implements Runnable {
    Record record;

    public Writer(Record record) {
        this.record = record;
        new Thread(this, "Writer").start();
    }

    @Override
    public void run() {
        for (int n = 0; n < 10; n++) {
            for (int i = 0; i < record.getMyArray().length; i++) {
                for (int j = 0; j < record.getMyArray()[i].length; j++) {
                    if (record.getMyArray()[i][j] % 2 == 0) record.getMyArray()[i][j] *= 2;
                }
            }
            record.write(this.record.getMyArray());
        }
    }
}
