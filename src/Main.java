import java.io.IOException;
import java.net.Socket;

public class Main {
    protected static Socket join;

    public static void main(String[] args) {
        try {
            System.out.println("client> connecting to 127.0.0.1:5000...");
            join = new Socket("127.0.0.1", 5000);
            System.out.println("client> success!");
            Controller controller = new Controller();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
