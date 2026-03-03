import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        try {
            ServerSocket server = new ServerSocket(5000);
            while (true) {
                System.out.println("server< waiting for client to connect");
                Socket conn = server.accept();
                System.out.println("server> connected to client " + conn);
                while (true) {
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
