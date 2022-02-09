package com.company;

import java.sql.*;
import java.util.Scanner;

public class AddDelete {
    public static Connection connection;
    public static Scanner scan = new Scanner(System.in);

    public static void AddProducts(){
        System.out.println("What is the product's code?");
        Integer code = scan.nextInt();
        String a = scan.nextLine();
        System.out.print("What is the product's name?");
        System.out.println();
        String name = scan.nextLine();
        System.out.print("What is the product's description?");
        System.out.println();
        String description = scan.nextLine();
        System.out.print("What is the product's price?");
        System.out.println();
        Integer price = scan.nextInt();
        a = scan.nextLine();
        System.out.print("What is the product's shipping?");
        System.out.println();
        Integer shipcost = scan.nextInt();
        a = scan.nextLine();
        try{
            connection = DriverManager.getConnection("jdbc:postgresql:postgres");
            PreparedStatement ps = connection.prepareStatement("INSERT INTO product (code, name, description, price, shipcost) VALUES(?, ?, ?, ?, ?)");
            ps.setInt(1, code);
            ps.setString(2, name);
            ps.setString(3, description);
            ps.setInt(4, price);
            ps.setInt(5, shipcost);
            ps.executeUpdate();
            ps.close();
        }catch(SQLException err) {
            err.printStackTrace();
            System.exit(1);
        }
    }

    public static void DeleteProduct(){
        System.out.println("What is the item's code for deletion?");
        Integer delete = scan.nextInt();
        delete.toString();
        String a = scan.nextLine();
        String deleteCode = "DELETE FROM product WHERE code = " + delete;
        try{
            connection = DriverManager.getConnection("jdbc:postgresql:postgres");
            PreparedStatement ps = connection.prepareStatement(deleteCode);
            ps.executeUpdate();
        }catch(SQLException err) {
            err.printStackTrace();
            System.exit(1);
        }
    }
}
