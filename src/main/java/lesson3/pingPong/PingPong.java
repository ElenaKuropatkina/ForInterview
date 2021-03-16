package lesson3.pingPong;

public class PingPong {

    private String string = "ping";

    public void printPing() {
        synchronized (this) {
            try {
                while (true) {
                    while (string != "ping") {
                        wait();
                    }
                    System.out.println(string);
                    string = "pong";
                    notify();
                }
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void printPong() {
        synchronized (this) {
            try {
                while (true) {
                    while (string != "pong") {
                        wait();
                    }
                    System.out.println(string);
                    string = "ping";
                    notify();
                }
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }

}
