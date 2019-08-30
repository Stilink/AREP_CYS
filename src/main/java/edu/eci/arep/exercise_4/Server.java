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
        PrintWriter outS = new PrintWriter(client.getOutputStream(), true);
		BufferedReader inS = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String line, oper="cos";
        while((line = inS.readLine())!= null){
            if(line.charAt(0)=='p'){
                double number=Math.PI/Integer.parseInt(line.substring(2));
                line = Double.toString(number);
            }
            if(line.length()>4 && line.substring(0,4).equals("fun:")){
                oper=line.substring(4,7);
            }else{
                if(oper.equals("sin")) outS.println(Math.sin(Double.parseDouble(line)));
                else if(oper.equals("cos")) outS.println(Math.cos(Double.parseDouble(line)));
                else outS.println(Math.tan(Double.parseDouble(line)));
            }
            System.out.println(oper);
        }
        System.out.println("ola k tal chavalada");
        outS.close();
		inS.close();
		client.close();
		serverSocket.close();
    }
}