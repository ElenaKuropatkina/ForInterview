package lesson3.pingPong;

public class Main {
    public static void main(String[] args) {

        final PingPong pingPong = new PingPong();

        Thread threadPing = new Thread(new Runnable() {

            public void run() {
                pingPong.printPing();
            }
        });

        Thread threadPong = new Thread(new Runnable() {

            public void run() {
                pingPong.printPong();
            }
        });

        threadPing.start();
        threadPong.start();
    }
}
