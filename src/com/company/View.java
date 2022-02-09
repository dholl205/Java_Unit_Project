package com.company;

import java.sql.*;
import java.util.Scanner;

public class View {

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
}
