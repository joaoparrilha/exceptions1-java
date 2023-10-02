package application;

import model.entities.Account;
import model.exceptions.BusinessException;

import java.util.Locale;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Holder: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Initial balance: ");
        double initialBalance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double withDrawLimit = sc.nextDouble();

        Account acc = new Account(number, holder, initialBalance, withDrawLimit);

        System.out.println();
        System.out.print("Enter the amount for withdraw: ");
        double amountWithDraw = sc.nextDouble();

        try {
            acc.withDraw(amountWithDraw);
            System.out.printf("New balance: %.2f", acc.getBalance());
        } catch (BusinessException e){
            System.out.println(e.getMessage());
        }



        sc.close();
    }
}
