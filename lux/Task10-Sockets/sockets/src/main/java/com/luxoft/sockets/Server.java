package com.luxoft.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int defaultPort = 4000;

    private int port = defaultPort;

    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public static void main(String[] args) throws IOException {
        int port = defaultPort;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        Server server = new Server(port);
        server.run();
        server.close();
    }

    public Server() throws IOException {
        this(defaultPort);
    }

    public Server(int port) throws IOException {
        setPort(port);
        serverSocket = new ServerSocket(port);
        System.out.println(String.format("Server created at port %d.", port));
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void run() throws IOException {
        socket = serverSocket.accept();
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream());
        System.out.println("Server is ready for request.");
        String line;
        while ((line = input.readLine()) != null) {
            System.out.println(String.format("Received: %s", line));
            output.println("echo: " + line);
            output.flush();
        }
    }

    public void close() throws IOException {
        input.close();
        output.close();
        socket.close();
    }
}
