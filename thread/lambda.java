package thread;

public class lambda {
    public static void main(String[] args) {
        int a_ = 1;
        ILike like = (int a) /* 这里可以去掉()和int */ -> {
            System.out.println("i like lambda");
        };
        like.lambda(a_);
    }
}

// 定义一个函数式接口
interface ILike{
    void lambda(int a);
}

