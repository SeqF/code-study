package test;

public class TestThreadLocal {

    //创建线程变量
    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        //在主线程中设置线程变量
        threadLocal.set("你好");
        //创建并启动子线程
        Thread thread = new Thread(() -> System.out.println("子线程:" + threadLocal.get()));
        thread.start();
        //主线程输出线程变量的值
        System.out.println("主线程：" + threadLocal.get());
    }
}

