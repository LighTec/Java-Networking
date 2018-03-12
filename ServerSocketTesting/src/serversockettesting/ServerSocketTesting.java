/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversockettesting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author kell-gigabyte
 */
public class ServerSocketTesting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);

        System.out.println("Server created, waiting for client.");

        Socket socket = server.accept();

        System.out.println("Client has connected.");

        InputStream inputStream = socket.getInputStream();

        InputStreamReader isReader = new InputStreamReader(inputStream);

        BufferedReader inputReader = new BufferedReader(isReader);

        System.out.println("Client wrote: " + inputReader.readLine());

        OutputStream os = socket.getOutputStream();

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
        
        pw.println("Hello from the server!");
        pw.flush();
    }

}
