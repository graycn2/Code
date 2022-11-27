package Tickets;

public class SaleWindows extends Ticket implements Runnable{

    @Override
    public void run() {
        while (true){
            synchronized (this){
                if(tickets==0){
                    System.out.println("票已经卖完了");
                    break;
                }else {
                    System.out.println(Thread.currentThread().getName()+"第"+tickets--+"张票");
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
