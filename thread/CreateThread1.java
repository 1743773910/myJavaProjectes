package thread;

// 创建线程方式一:继承Thread类，重写run()
public class CreateThread1 extends Thread{
    public void run(){
        for(int i = 0; i < 200; i++){
            System.out.println("watching" + i);
        }
    }

    public static void main(String[] args) {
        // 创建一个线程对象
        CreateThread1 createThread = new CreateThread1();
        // 调用start方法
        createThread.start();
        // 调用start方法后接着往下执行和执行run方法同时进行

        for(int i = 0; i < 200; i++){
            System.out.println("我在学习多线程" + i);
        }
    }
}


