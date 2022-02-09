package com.company;

import java.sql.*;
import java.util.Scanner;

public class Search {

    public static Connection connection;
    public static Scanner scan = new Scanner(System.in);


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




}
