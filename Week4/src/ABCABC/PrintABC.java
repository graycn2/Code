package ABCABC;

public class PrintABC {
    private int flag=0;

    public synchronized void A() throws InterruptedException {
        for(int i=0;i<5;i++){
            while(flag!=0){
                wait();
            }
            System.out.println("A");
            flag=1;
            notifyAll();
        }
    }

    public synchronized void B() throws InterruptedException {
        for(int i=0;i<5;i++){
            while(flag!=1){
                wait();
            }
            System.out.println("B");
            flag=2;
            notifyAll();
        }
    }

    public synchronized void C() throws InterruptedException {
        for(int i=0;i<5;i++){
            while(flag!=2){
                wait();
            }
            System.out.println("C");
            flag=0;
            notifyAll();
        }
    }

    public static void main(String[] args) {
        PrintABC printABC = new PrintABC();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printABC.A();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printABC.B();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printABC.C();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
