
public class Reader implements Runnable {
    Record record;

    public Reader(Record record) {
        this.record = record;
        new Thread(this, "Reader").start();
    }

    @Override
    public void run() {
        for (int n = 0; n < 10; n++) {
            record.read();
        }
    }
}
