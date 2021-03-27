package leetcode.S1115;

import java.util.concurrent.Semaphore;

public class FooBar {

    private int n;

    private Semaphore semaphoreFoo = new Semaphore(1);

    private Semaphore semaphoreBar = new Semaphore(1);

    public FooBar(int n) {
        this.n = n;
        try {
            semaphoreBar.acquire();
        }catch(Exception e){
        }
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                semaphoreFoo.acquire();
            }catch (Exception e){

            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphoreBar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                semaphoreBar.acquire();
            }catch (Exception e){
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphoreFoo.release();
        }
    }
}
