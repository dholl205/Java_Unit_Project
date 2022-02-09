package com.company;

import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        while(true){
            System.out.println("Product Area");
            System.out.println("Would you like to view ('all', max 'price', 'name', 'code'), 'add', 'delete' products, 'update' + ('price', 'shipping', 'description'), or 'q'uit? ");
            String act = scan.nextLine();
            act.toLowerCase();
            if (act.equals("delete")){
                    AddDelete.DeleteProduct();
                }
            else if (act.equals("add")){
                    AddDelete.AddProducts();
                }
            else if (act.equals("q")){
                    System.exit(1);
                }
            else if (act.equals("all")){
                    View.ViewAllProducts();
                }
            else if (act.equals("price")){
                    Search.FindByMax();
                }
            else if (act.equals("name")){
                    Search.FindByName();
                }
            else if (act.equals("code")){
                    Search.FindByCode();
                }
            else if (act.equals("update price")){
                Update.UpdatePrice();
            }
            else if (act.equals("update description")){
                Update.UpdateDesc();
            }
            else if (act.equals("update shipping")) {
                Update.UpdateShip();
            }
            else{
                System.out.println("Please choose a choice between the '' marks.");
            }
        }
    }
}
