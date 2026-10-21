package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Product;
import model.exceptions.DomainException;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter product data:");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            System.out.print("Initial quantity: ");
            int quantity = sc.nextInt();

            Product product = new Product(name, price, quantity);

            System.out.print("\nEnter quantity for withdraw: ");
            int withdrawQuantity = sc.nextInt();
            product.removeProducts(withdrawQuantity);
            System.out.print("Updated stock:" + product.toString());
        } catch (DomainException e) {
            System.out.print(e.getMessage());

        }catch(InputMismatchException e){
            System.out.print("Input error: You must enter a valid integer number");
        } catch (Exception e) {
            System.out.print("Unexpected error");
        } finally{
            sc.close();
        }
    }

}
