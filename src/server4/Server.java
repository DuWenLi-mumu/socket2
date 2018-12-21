package server4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 创建服务器并启动
 * 1.请求
 * 2.响应
 */
public class Server {
    public static ArrayList<String> list;
    private ServerSocket server;
    public static final String CRLF="\r\n";
    public static final String BLANK=" ";

    private boolean isShutDown= false;
    /**
     * @param args
     */
    public static void main(String[] args) {
        Server server = new Server();
        server.start();

    }
    /**
     * 启动方法
     */
    public void start(){
        start(8888);

    }
    /**
     * 指定端口的启动方法
     */
    public void start(int port){
        list=new ArrayList<>();
        list.add("/webpage.html");
        list.add("/index.html");
        list.add("/webpage2.html");
        try {
            server = new ServerSocket(port);
            this.receive();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("322");
            stop();
        }

    }
    /**
     * 接收客户端
     */
    private void receive(){
        try {
            while(!isShutDown){
                new Thread(new Dispatcher(server.accept())).start();
            }
        } catch (IOException e) {
            //e.printStackTrace();
            stop();
        }

    }

    /**
     * 停止服务器
     */
    public void stop(){
        isShutDown=true;
        CloseUtil.closeSocket(server);
    }


}

