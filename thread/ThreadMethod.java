package thread;

public class ThreadMethod implements Runnable{
    private boolean flag = true;
    @Override
    public void run() {
        int i = 0;
        while(flag){
            System.out.println("run Thread" + i++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadMethod threadMethod = new ThreadMethod();
        new Thread(threadMethod).start();

        for(int i = 0; i < 100000; i++){
            if(i == 90000){
                // Thread.sleep(10); // sleep不会释放锁
                // 调用stop方法切换标志位，停止线程
                threadMethod.stop();
            }
        }
    }
    // 1.线程停止
    public void stop(){this.flag = false;}
    // 2.线程休眠
    // Thread.sleep(10)
    // 3.线程重新竞争
    // Thread.yield();
    // 4.线程强制执行
    // Thread.join();
    // 5.观测线程状态
    // Thread thread = new Thread(() -> {
    //     // lambda方法，代码块,实质是run方法的重写
    // };);
    // Thread.State state = thread.getState();
    // 6.线程优先级:1为最低，10为最高，5为normal priority
    // Thread.currentThread().getPriority();
    // t.getPriority(num);
    // 7.守护线程,虚拟机不必等待守护线程执行完毕，只需确保用户线程执行完毕
    // Thread thread = new Thread(new 类名()); // 此类中必须有run方法
    // thread.setDaemon(true); // 设为守护线程
}
