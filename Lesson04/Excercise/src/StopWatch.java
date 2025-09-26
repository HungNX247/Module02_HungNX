public class StopWatch {
    private long startTme, endTime;

    public long getStartTime() {
        return startTme;
    }

    public long getEndTime() {
        return endTime;
    }

    public StopWatch() {
        startTme = System.currentTimeMillis();
    }

    public void start() {
        startTme = System.currentTimeMillis();
    }

    public void stop() {
        endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return endTime - startTme;
    }

    public static void main(String[] args) {
        StopWatch sWatch = new StopWatch();

        sWatch.start();
        long sum = 0;
        for (int i = 0; i < 100000; i++) {
            sum += i;
        }
        sWatch.stop();

        System.out.println("Start time: " + sWatch.getStartTime() + " ms");
        System.out.println("End time: " + sWatch.getEndTime() + " ms");
        System.out.println("Elapsed time: " + sWatch.getElapsedTime() + " ms");
        System.out.println("Sum: " + sum + " ms");
    }
}
