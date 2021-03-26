package concurent;

import java.util.concurrent.Semaphore;

public class MutiThreadPrint {

    private static Semaphore semaphoreA = new Semaphore(1);

    private static Semaphore semaphoreB = new Semaphore(1);

    private static Semaphore semaphoreC = new Semaphore(1);


    static class TheadA extends Thread {
        @Override
        public void run() {

            try {
                semaphoreA.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("1");
            semaphoreB.release();

        }
    }

    static class TheadB extends Thread {
        @Override
        public void run() {
            try {
                semaphoreB.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("2");
            semaphoreC.release();

        }
    }

    static class TheadC extends Thread {
        @Override
        public void run() {
            try {
                semaphoreC.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("3");
            semaphoreA.release();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        TheadA threadA = new TheadA();
        TheadB threadB = new TheadB();
        TheadC threadC = new TheadC();
        semaphoreB.acquire();
        semaphoreC.acquire();

        threadA.start();
        threadB.start();
        threadC.start();

    }


}
