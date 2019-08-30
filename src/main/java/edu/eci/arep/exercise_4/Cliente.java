package edu.eci.arep.exercise_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Cliente
 */
public class Cliente {

    public static void main(String[] args) throws Exception{
        Socket client = new Socket("127.0.0.1", 35000);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader inC = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter outC = new PrintWriter(client.getOutputStream(), true);
        String line;
        while((line = br.readLine()) != null) {
            outC.println(line);
            System.out.println(inC.readLine());
        }
        br.close();
        inC.close();
        outC.close();
        client.close();
    }
}