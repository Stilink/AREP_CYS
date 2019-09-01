package edu.eci.arep.exercise_4_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * ServerHTTP
 */
public class ServerHTTP {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(35000);
        Socket client = serverSocket.accept();

        PrintWriter outS = new PrintWriter(client.getOutputStream(), true);
		BufferedReader inS = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String line;
        while((line = inS.readLine())!= null){
            System.out.println("Recibido: "+line);   
            if(!inS.ready()) break;        
        }
        outS.println("HTTP/1.1 200 OK");
		outS.println("Content-Type: text/html");
		outS.println("\r\n");
		
		String docHtml = "<!DOCTYPE html>" + "<html>" + "<head>" + "<title>Test</title>" + "</head>" + "<body>" + "Test" + "</body>"
                + "</html>" + line;
        outS.println(docHtml);
        outS.close();
		inS.close();
		client.close();
		serverSocket.close();
    }
}