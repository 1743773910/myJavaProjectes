package thread.ThreadSafe;

public class Safe implements Runnable{
    private int ticketNums = 10;
    boolean flag = true;
    @Override
    public void run() {
        while(flag){
            try {
                Thread.sleep(100);
                buy();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    // synchronized 后，方法变为安全方法
    private synchronized void buy() throws InterruptedException {
        if(ticketNums <= 0){
            flag = false;
            return;
        }

        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNums--);
    }
    public static void main(String[] args) {
        Safe safe = new Safe();
        new Thread(safe, "w").start();
        new Thread(safe, "n").start();
        new Thread(safe, "t").start();
    }
}
