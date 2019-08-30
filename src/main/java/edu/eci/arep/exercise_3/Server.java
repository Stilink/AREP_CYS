package edu.eci.arep.exercise_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server
 */
public class Server {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(35000);
        Socket client = serverSocket.accept();
        PrintWriter outS = new PrintWriter(client.getOutputStream(), true);
		BufferedReader inS = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String line;
        while((line = inS.readLine())!= null){
            double number = Double.parseDouble(line);
            double result = Math.pow(number,2 );
            outS.println(result);

        }
        outS.close();
		inS.close();
		client.close();
		serverSocket.close();
    }
}