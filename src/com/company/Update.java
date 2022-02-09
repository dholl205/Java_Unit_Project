package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {

    public static Connection connection;
    public static Scanner scan = new Scanner(System.in);

    public static void UpdatePrice(){
        System.out.println("What is the item code to update?");
        Integer update = scan.nextInt();
        String a = scan.nextLine();
        System.out.println("What is the new price?");
        Integer newPrice = scan.nextInt();
        a = scan.nextLine();
        String UpdateIt = "UPDATE product SET price = ? " + "Where code = ?";
        try{
            connection = DriverManager.getConnection("jdbc:postgresql:postgres");
            PreparedStatement ps = connection.prepareStatement(UpdateIt);
            ps.setInt(1, newPrice);
            ps.setInt(2, update);
            ps.executeUpdate();
        }catch(SQLException err) {
            err.printStackTrace();
            System.exit(1);
        }
    }
    public static void UpdateShip(){
        System.out.println("What is the item code to update?");
        Integer update = scan.nextInt();
        String a = scan.nextLine();
        System.out.println("What is the new shipping price?");
        Integer newShip = scan.nextInt();
        a = scan.nextLine();
        String UpdateIt = "UPDATE product SET shipcost = ? " + "Where code = ?";
        try{
            connection = DriverManager.getConnection("jdbc:postgresql:postgres");
            PreparedStatement ps = connection.prepareStatement(UpdateIt);
            ps.setInt(1, newShip);
            ps.setInt(2, update);
            ps.executeUpdate();
        }catch(SQLException err) {
            err.printStackTrace();
            System.exit(1);
        }
    }
    public static void UpdateDesc(){
        System.out.println("What is the item code to update?");
        Integer update = scan.nextInt();
        String a = scan.nextLine();
        System.out.println("What is the new description?");
        String newDesc = scan.nextLine();
        String UpdateIt = "UPDATE product SET description = ? " + "Where code = ?";
        try{
            connection = DriverManager.getConnection("jdbc:postgresql:postgres");
            PreparedStatement ps = connection.prepareStatement(UpdateIt);
            ps.setString(1, newDesc);
            ps.setInt(2, update);
            ps.executeUpdate();
        }catch(SQLException err) {
            err.printStackTrace();
            System.exit(1);
        }
    }
}
