package designPatterns.singleton;

public class Main {
    public static void main(String[] args){

        //Without Thread safe

        WithoutThreadSafe withoutThreadSafe = WithoutThreadSafe.getInstance();
        System.out.println(withoutThreadSafe);
        WithoutThreadSafe withoutThreadSafe2 = WithoutThreadSafe.getInstance();
        System.out.println(withoutThreadSafe2);
        WithoutThreadSafe withoutThreadSafe3 = WithoutThreadSafe.getInstance();
        System.out.println(withoutThreadSafe3);

        // With Thread Safe

        long start = System.nanoTime();
        Runnable task =() ->{
            ThreadSafe instance = ThreadSafe.getInstance();
            System.out.println(Thread.currentThread().getName()+" " + instance);
        };
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Time taken: " + duration + " ns");

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
