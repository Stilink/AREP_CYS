package edu.eci.arep.exercise_1;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * exersice_1
 */
public class exersice_1 {

    public static void main(String[] args) {
        try {
            URL eci = new URL("https://www.escuelaing.edu.co:8080/es/public/test/index.html?number=3.142234234#TEST");
            System.out.println("The URL is: "+eci.toString());
            print(eci);
        } catch (MalformedURLException e) {

            System.out.println("Bad URL");
        }
    }

    static void print(URL url) {
        System.out.println(url.getProtocol());
        System.out.println(url.getAuthority());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getPath());
        System.out.println(url.getQuery());
        System.out.println(url.getFile());
        System.out.println(url.getRef());
    }

}