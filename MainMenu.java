import javax.management.MBeanRegistration;
import java.util.Scanner;

public class MainMenu extends OptionMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("------ Welcome to ATM Project ------");
        System.out.println("Enter number of account creation");
        int n = sc.nextByte();
        MainMenu MU[] = new MainMenu[n];
        for (int i = 0; i < n; i++) {
            MU[i] = new MainMenu();
            System.out.println("Enter Name");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Enter account number");
            int acc = sc.nextInt();
            MU[i].OpenAccount(name, acc);
        }


        int x = 0;
        got: do {
            //hello
            System.out.println("Enter Your Account Number");
            int accountNo = sc.nextInt();
            for (int i = 0; i < n; i++)
                if (MU[i].myAccountNo == accountNo)
                    x = 1;
            if (x == 1)
                menu();
            else
                System.out.println("Account number invalid please re-enter");
            continue got;
        }while(true);
    }
    public static void menu(){
        OptionMenu om=new OptionMenu();
        Scanner sc=new Scanner(System.in);
        go : do {
            System.out.println("Enter options and perform your banking");
            System.out.println("1. Add Funds");
            System.out.println("2. Check Balance");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Exit");
            int option = sc.nextByte();
            double balance;
            if (option == 1) {
                System.out.println("Enter amount to be added");
                double fund = sc.nextDouble();
                balance = om.addFunds(fund);
                System.out.println("Balance added successfully");
                System.out.println("Your new Balance is : Rs." + balance);
                continue go;
            } else if (option == 2) {
                System.out.println("Your balance is : Rs." + om.seeBalance());
                continue go;
            } else if (option == 3) {
                System.out.println("Your balance is : Rs." + om.seeBalance());
                System.out.println("Enter amount to withdraw");
                double withdraw = sc.nextDouble();
                double withdrawAmount = om.withdrawBalance(withdraw);
                if (withdrawAmount > 0) {
                    System.out.println("Your Remaining Balance is : Rs" + withdrawAmount);
                    continue go;
                } else {
                    System.out.println("Can not initiate as your account balance is low");
                    continue go;
                }
            } else if (option == 4) {
                System.out.println("Thank You");
                break;
            } else {
                System.out.println("Enter choice carefully");
                continue go;
            }
        }while (true);
    }
}
