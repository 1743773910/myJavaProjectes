package thread;

// 定义MyRunnable类实现Runnable接口，重写run方法
// 执行线程需要丢入runnable接口实现类
public class createThread2 implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 200; i++){
            System.out.println("run" + i);
        }
    }

    public static void main(String[] args) {
        // 创建runnable接口的实现类的对象
        createThread2 createThread = new createThread2();
        // 创建线程对象，通过线程对象开启线程
        Thread thread = new Thread(createThread);
        thread.start();

        for(int i = 0; i < 200; i++){
            System.out.println("main" + i);
        }
    }
}
