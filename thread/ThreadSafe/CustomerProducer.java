package thread.ThreadSafe;

// 利用缓冲区解决
// 生产者、消费者、产品、缓冲区
public class CustomerProducer {
    public static void main(String[] args) {
        Syncontainer container = new Syncontainer();

        new Producer(container).start();
        new Customer(container).start();

    }

}
class Producer extends Thread{
    Syncontainer container;
    public Producer(Syncontainer container){
        this.container = container;
    }
    // 生产方法
    @Override
    public synchronized void run() {
        for(int i = 0; i < 100; i++){
            try {
                container.push(new Chicken(i));
                System.out.println("product " + i + " chicken");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Customer extends Thread{
    Syncontainer container;
    public Customer(Syncontainer container){
        this.container = container;
    }

    @Override
    public synchronized void run() {
        for(int i = 0; i < 100; i++){
            try {
                System.out.println("eat " + container.pop().id + " chicken");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
// 产品
class Chicken{
    int id;
    public Chicken(int id){
        this.id = id;
    }
}
// 容器
class Syncontainer{
    Chicken[] chickens = new Chicken[10];
    int cnt = 0;
    // 生产者生产
    public synchronized void push(Chicken chicken) throws InterruptedException {
        if(cnt >= chickens.length){
            // 通知消费者等待
            this.wait();
        }
        chickens[cnt++] = chicken;
        // 通知消费者消费
        this.notifyAll();
    }
    // 消费者消费
    public synchronized Chicken pop() throws InterruptedException {
        if(cnt <= 0){
            this.wait();
            // 消费者阻塞，等待生产者生产
        }
        Chicken chicken = chickens[--cnt];
        this.notifyAll();
        return chicken;
    }
}

