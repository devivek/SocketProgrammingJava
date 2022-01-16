package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            System.out.println("Waiting for Client");
            ServerSocket ss = new ServerSocket(8809);
            Socket socket = ss.accept();
            System.out.println("Connection Established");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            while (socket.isConnected()){
                String str[] = in.readLine().split(":");
                Integer option = Integer.parseInt(str[0]);
                Integer num1 = Integer.parseInt(str[1]);
                Integer num2 = Integer.parseInt(str[2]);
                String res = "";
                switch (option){
                    case 1 : res = "Addition is " + (num1 + num2);break;
                    case 2 : res = "Subtraction is " + (num1 - num2);break;
                    case 3 : res = "Multiplication is " + (num1 * num2);break;
                    case 4 : res = "Division is " + (num1 / num2);break;
                    default:break;
                }
                System.out.println(res);
                out.println(res);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
