package leetCode;

import java.util.concurrent.CountDownLatch;

public class Main2 {
    private volatile int value = 1;
    private final Runnable a = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(100);
                latch.countDown();
                while (value < 100) {
                    try {
                        synchronized (latch) {
                            if (value % 2 == 1) {
                                System.out.println(value ++);
                                latch.notifyAll();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private final Runnable b = new Runnable() {
        @Override
        public void run() {
            try {
                latch.await();
                while (value < 100) {
                    synchronized (latch) {
                        if (value % 2 == 0) {
                            System.out.println(value ++);
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private final CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        Main2 m = new Main2();
        m.test();
    }

    private void test() {
        new Thread(b).start();
        new Thread(a).start();
    }
}
