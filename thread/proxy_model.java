package thread;

// 代理模式
// 真实对象和代理对象都要实现同一个接口
// 代理对象要代理真实对象
// 优点：代理对象可以做真实对象做不了的事情
// 真实对象可以去做自己的事情
public class proxy_model {
    public static void main(String[] args) {
        WeddingConpany weddingConpany = new WeddingConpany(new You());
        weddingConpany.HappyMarry();
    }
}

interface Marry{
    public void HappyMarry();
}

// 真实角色，你去结婚
class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("HappyMarry");
    }
}
// 代理角色，帮你结婚
class WeddingConpany implements Marry{
    private Marry target;
    public WeddingConpany(Marry target){
        this.target = target;
    }
    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry(); // 真实对象
        after();
    }
    private void after() {
        System.out.println("收尾款");
    }
    private void before() {
        System.out.println("布置现场");
    }
}












