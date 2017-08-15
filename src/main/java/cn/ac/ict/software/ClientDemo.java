package cn.ac.ict.software;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ClientDemo {

    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 8090;
    private static final int TIMEOUT = 30000;


    public void startClient() {
        TTransport transport = null;
        try {
            transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            HelloWorldService.Client client = new HelloWorldService.Client(protocol);
            transport.open();
            User user = new User();
            user.username = "haiker";
            user.age = 26;
            String result = client.sayHello(user);
            System.out.println("Thrify client result is: " + result);
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ClientDemo client = new ClientDemo();
        client.startClient();

    }
}
