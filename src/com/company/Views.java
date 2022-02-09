package com.company;

import java.sql.*;
import java.util.Scanner;

public class Views {

    public static Connection connection;
    public static Scanner scan = new Scanner(System.in);

    public static void ViewAllProducts(){
        try {
            connection = DriverManager.getConnection("jdbc:postgresql:postgres");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM product");
            while (rs.next()){
                Integer price = rs.getInt("price");
                Integer ship = rs.getInt("shipcost");
                Integer total = price + ship;
                System.out.print("Name: " + rs.getString("name") + ", ");
                System.out.print("Desc: " + rs.getString("description") + " ");
                System.out.print("Code: " + rs.getInt("code") + ", ");
                System.out.print("Price: $" + price + ", ");
                System.out.print("Shipping: $" + ship + ", ");
                System.out.println("Total: $" + total);
                System.out.println();
            }
            rs.close();
            st.close();
        }catch(SQLException err) {
            err.printStackTrace();
            System.exit(1);
        }
    }

    public static void FindByCode(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the product code.");
        Integer codeVal = scan.nextInt();
        Integer a = 0;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql:postgres");
            PreparedStatement st = connection.prepareStatement("SELECT * FROM product WHERE code = ?");
            st.setInt(1, codeVal);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                a++;
                Integer price = rs.getInt("price");
                Integer ship = rs.getInt("shipcost");
                Integer total = price + ship;
                System.out.print("Name: " + rs.getString("name") + ", ");
                System.out.print("Desc: " + rs.getString("description") + " ");
                System.out.print("Code: " + rs.getInt("code") + ", ");
                System.out.print("Price: $" + price + ", ");
                System.out.print("Shipping: $" + ship + ", ");
                System.out.println("Total: $" + total);
                System.out.println();
                if(a==0){
                    System.out.println("No product with that code.");
                }
            }
            rs.close();
            st.close();
        }catch(SQLException err) {
            err.printStackTrace();
            System.exit(1);
        }
    }

    public static void FindByName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the product name.");
        String nameVal = scan.nextLine();
        Integer a = 0;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql:postgres");
            PreparedStatement st = connection.prepareStatement("SELECT * FROM product WHERE name = ?");
            st.setString(1, nameVal);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                a++;
                Integer price = rs.getInt("price");
                Integer ship = rs.getInt("shipcost");
                Integer total = price + ship;
                System.out.print("Name: " + rs.getString("name") + ", ");
                System.out.print("Desc: " + rs.getString("description") + " ");
                System.out.print("Code: " + rs.getInt("code") + ", ");
                System.out.print("Price: $" + price + ", ");
                System.out.print("Shipping: $" + ship + ", ");
                System.out.println("Total: $" + total);
                System.out.println();
                if(a==0){
                    System.out.println("No product with that name.");
                }
            }
            rs.close();
            st.close();
        }catch(SQLException err) {
            err.printStackTrace();
            System.exit(1);
        }
    }

    public static void FindByMax(){
        System.out.println("Enter the max total price.");
        Integer nameVal = scan.nextInt();
        Integer a = 0;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql:postgres");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM product");
            while (rs.next()){
                a++;
                Integer price = rs.getInt("price");
                Integer ship = rs.getInt("shipcost");
                Integer total = price + ship;
                if(total <= nameVal){
                    System.out.print("Name: " + rs.getString("name") + ", ");
                    System.out.print("Desc: " + rs.getString("description") + " ");
                    System.out.print("Code: " + rs.getInt("code") + ", ");
                    System.out.print("Price: $" + price + ", ");
                    System.out.print("Shipping: $" + ship + ", ");
                    System.out.println("Total: $" + total);
                    System.out.println();}
                if(a==0){
                    System.out.println("No product less than that.");
                }
            }
            rs.close();
            st.close();
        }catch(SQLException err) {
            err.printStackTrace();
            System.exit(1);
        }
    }

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
