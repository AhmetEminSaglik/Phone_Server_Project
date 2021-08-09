package countdowntime;

public class CountDownTime {
    private int ms;
    public boolean isTimeUp = true;

    public CountDownTime(int ms) {
        this.ms = ms;

    }

    public long beginTime = 0;

    public Thread thread;

    public void startTime() {
        isTimeUp = false;
        beginTime = System.currentTimeMillis();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    long value = System.currentTimeMillis() - beginTime;
                    if (value >= ms) {
                        isTimeUp = true;
                        return;
                    }
                }
            }
        });
        thread.start();
    }

    public void resetTime() {
        beginTime = System.currentTimeMillis();
    }
}
