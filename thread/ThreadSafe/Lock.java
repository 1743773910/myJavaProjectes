package thread.ThreadSafe;

import java.util.concurrent.locks.ReentrantLock;

// lock锁
public class Lock {
    public static void main(String[] args) {
        Lock2 lock2 = new Lock2();
        new Thread(lock2).start();
        new Thread(lock2).start();
        new Thread(lock2).start();
    }
}

class Lock2 implements Runnable{
    private int ticketNums = 10;
    // 定义lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            lock.lock(); // 加锁
            if(ticketNums > 0){
                try {
                    Thread.sleep(100);
                    System.out.println(ticketNums--);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }else{
                break;
            }
        }
    }


}
