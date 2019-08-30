package edu.eci.arep.exercise_4;

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
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String inputLine, outputLine,fun="cos";
        while((inputLine = in.readLine())!= null){
            System.out.println("Mensaje:" + inputLine);
            outputLine = "Respuesta: ";
            String rta="";

            if (inputLine.length() > 4 && inputLine.substring(0, 4).equals("fun:")) {
                if (inputLine.contains("sin")) {
                    fun = "sin";
                } else if (inputLine.contains("cos")) {
                    fun = "cos";
                } else if (inputLine.contains("tan")) {
                    fun = "tan";
                }
            } else {
                if (fun.equals("cos")) {
                    rta = Double.toString(Math.cos(Double.parseDouble(inputLine)));
                } else if (fun.equals("sin")) {
                    rta = Double.toString(Math.sin(Double.parseDouble(inputLine)));
                } else if (fun.equals("tan")) {
                    rta = Double.toString(Math.tan(Double.parseDouble(inputLine)));
                } 
            }
            out.println(outputLine + rta);
        }
        out.close();
		in.close();
		client.close();
		serverSocket.close();
    }
}