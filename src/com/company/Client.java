package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args){
        try{
            System.out.println("Client Started");
            Socket sc = new Socket("localhost", 8809);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader socketInputStream = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            PrintWriter socketOutput =  new PrintWriter(sc.getOutputStream(), true);
            int option = 0;
            int num1 = 0;
            int num2 = 0;
           do{
                System.out.println("Choose Operation");
                System.out.println("1 Add");
                System.out.println("2 Sub");
                System.out.println("3 Mulp");
                System.out.println("4 Div");
                System.out.println("Choose Option");
                option = Integer.parseInt(userInput.readLine());
                System.out.println("Enter Num1");
                num1 = Integer.parseInt(userInput.readLine());
                System.out.println("Enter Num2");
                num2 = Integer.parseInt(userInput.readLine());
                socketOutput.println(option+":"+num1+":"+num2);
                String ans = socketInputStream.readLine();
                System.out.println(ans);
            }while(true);


        }catch(Exception e){

        }
    }

}
