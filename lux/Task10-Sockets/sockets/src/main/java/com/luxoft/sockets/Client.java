package com.luxoft.sockets;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final String stopWord = "quit";

    private static final String defaultHost = "localhost";
    private static final int defaultPort = 4000;

    private int port;
    private String host = defaultHost;

    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public static void main(String[] args) throws IOException {
        int port = Client.defaultPort;
        String host = defaultHost;
        if (args.length > 1) {
            host = args[0];
            port = Integer.parseInt(args[1]);
        }
        Client client = new Client(host, port);
        client.run();
    }

    public Client() throws IOException {
        this(defaultHost, Client.defaultPort);
    }

    public Client(String host, int port) throws IOException {
        setPort(port);
        socket = new Socket(host, port);
        System.out.println(String.format("Client is listening at port %d.", port));
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void run() throws IOException {
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream(), true);

        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format("Client is ready to send request. Type \"%s\" to quit.", Client.stopWord));
        String line;
        while ((line = scanner.nextLine()) != null) {
            String sendLine = line  + "\n";
            if (line.equals(stopWord)) {
                System.out.println("Finishing...");
                break;
            }
            output.write(sendLine);
            output.flush();

            String receivedLine = input.readLine();
            System.out.println(String.format("Received: %s", receivedLine));
        }
    }

    public void close() throws IOException {
        input.close();
        output.close();
        socket.close();
    }
}
