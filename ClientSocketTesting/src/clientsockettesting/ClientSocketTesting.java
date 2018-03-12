/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clientsockettesting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author kell-gigabyte
 */
public class ClientSocketTesting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 1234);
        
        OutputStream os = client.getOutputStream();
        
        OutputStreamWriter osw = new OutputStreamWriter(os);
        
        PrintWriter pw = new PrintWriter(osw);
        
        pw.println("Hello World! From the client!");
        
        pw.flush();
        
        InputStream is = client.getInputStream();
        
        BufferedReader ir = new BufferedReader(new InputStreamReader(is));
        
        System.out.println("Server wrote: " + ir.readLine());
        
    }

}
