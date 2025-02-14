package ajava.thread;

public class FalseSharingExample {
    private static final int NUM_THREADS = 4;
    private static final long ITERATIONS = 500L * 1000L * 1000L;

    private static class VolatileLong {
//        @sun.misc.Contended
        public volatile long value = 0L;
    }

    private final VolatileLong[] longs;

    public FalseSharingExample() {
        longs = new VolatileLong[NUM_THREADS];
        for (int i = 0; i < longs.length; i++) {
            longs[i] = new VolatileLong();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final FalseSharingExample example = new FalseSharingExample();
        long start = System.nanoTime();
        runTest(example);
        System.out.println("Duration = " + (System.nanoTime() - start));
    }

    private static void runTest(FalseSharingExample example) throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < threads.length; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                long l = ITERATIONS + 1;
                while (0 != --l) {
                    example.longs[index].value = l;
                }
            });
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }
    }
}
