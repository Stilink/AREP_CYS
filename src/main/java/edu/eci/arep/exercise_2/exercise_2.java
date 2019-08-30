package edu.eci.arep.exercise_2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * exercise_2
 */
public class exercise_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Por favor ingrese su página: ");
        String urlString = br.readLine();
        URL url = new URL(urlString);
        FileWriter file = new FileWriter("web.html");

        String line;
        br = new BufferedReader(new InputStreamReader(url.openStream()));
        while((line = br.readLine()) != null){
            file.append(line);
        }
        file.close();

    }
}