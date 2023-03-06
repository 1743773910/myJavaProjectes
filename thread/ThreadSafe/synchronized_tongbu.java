package thread.ThreadSafe;
// 同步:是指一个进程在执行某个请求的时候，若该请求需要一段时间
// 才能返回信息，那么，这个进程将会一直等待下去，直到收到返回信息
// 才继续执行下去。

// 同步方法:
// 1.加上synchronized关键字: public synchronized void func(){};
//       synchronized 锁的东西默认是this
// 2.synchronized同步块控制对对象的访问，即
//   synchronized(要锁的对象){代码块}
//   锁的对象就是变化的量，需要增删改的对象
public class synchronized_tongbu {

}
