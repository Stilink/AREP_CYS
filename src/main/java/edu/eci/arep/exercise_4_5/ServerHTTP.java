package edu.eci.arep.exercise_4_5;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import javax.imageio.ImageIO;

/**
 * ServerHTTP
 */
public class ServerHTTP {

    public static void main(String[] args) throws Exception {
        while (true) {
            ServerSocket serverSocket = new ServerSocket(35000);
            Socket clientSocket = serverSocket.accept();
            while (!clientSocket.isClosed()) {
                PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(clientSocket.getOutputStream(), StandardCharsets.UTF_8), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String inputLine, totalInput = "";
                while ((inputLine = in.readLine()) != null) {
                    totalInput = totalInput + "\n" + inputLine;
                    System.out.println("Recibido: " + inputLine);
                    if (inputLine.contains("GET")) {
                        String[] tempArray = inputLine.split(" ");
                        String path = System.getProperty("user.dir") + "/resources" + tempArray[1];
                        BufferedReader br = null;
                        try {
                            br = new BufferedReader(new FileReader(path));
                        } catch (Exception e) {
                            out.println("HTTP/1.1 404 Not Found");
                            out.println("Content-Type: text/html");
                            System.out.println("Not found");
                            e.printStackTrace();
                        }
                        if (path.contains(".html")) {
                            html(out, br);
                        } else if (path.contains(".png")) {
                            png(out, clientSocket, tempArray);
                        }

                        out.close();
                    }
                    if (!in.ready()) {
                        break;
                    }
                }
                in.close();
            }
            clientSocket.close();
            serverSocket.close();
        }
    }

    public static void html(PrintWriter out, BufferedReader br) throws Exception {
        out.write("HTTP/1.1 200 OK");
        out.println("Content-Type: text/html");
        out.println();
        String temp = br.readLine();
        while (temp != null) {
            out.write(temp);
            temp = br.readLine();
        }
    }

    public static void png(PrintWriter out, Socket clientSocket, String[] tempArray) throws Exception{
        out.write("HTTP/1.1 200 OK");
        out.println("Content-Type: image/png");
        out.println();
        BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir") + "/resources" + tempArray[1]));
        ImageIO.write(image, "PNG", clientSocket.getOutputStream());
    }

}