package com.company;

import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        while(true){
            System.out.println("Product Area");
            System.out.println("Would you like to view ('all', max 'price', 'name', 'code'), 'add', 'delete' products, or 'q'uit? To change, delete then add back with changed value.");
            String act = scan.nextLine();
            act.toLowerCase();
            if (act.equals("delete")){
                    Views.DeleteProduct();
                }
            else if (act.equals("add")){
                    Views.AddProducts();
                }
            else if (act.equals("q")){
                    System.exit(1);
                }
            else if (act.equals("all")){
                    Views.ViewAllProducts();
                }
            else if (act.equals("price")){
                    Views.FindByMax();
                }
            else if (act.equals("name")){
                    Views.FindByName();
                }
            else if (act.equals("code")){
                    Views.FindByCode();
                }
            else{
                System.out.println("Please choose a choice between the '' marks.");
            }
        }
    }
}
