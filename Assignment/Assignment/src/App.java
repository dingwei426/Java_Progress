import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.println("\t\t__________________________________________");
        System.out.println("\t\t|                                        |");
        System.out.println("\t\t|                                        |");
        System.out.println("\t\t|      UX Gallery Management System      |");
        System.out.println("\t\t|                                        |");
        System.out.println("\t\t|________________________________________|");

        boolean login;
        do {
            login = loginAccount();
        } while (!login);

        boolean validOption;
        while (login) {
            do {
                System.out.println("1. Customer Menu\n2. Artist Menu\n3. Artwork Menu\n4. Reset Account\n5. Logout");
                System.out.print("Enter option: ");
                int option = -1;
                validOption = false;

                do {
                    try {
                        option = Integer.parseInt(input.nextLine());
                        validOption = true;
                    } catch (Exception ex) {
                        System.out.println("Invalid Option.");
                    }
                } while (!validOption);

                switch (option) {
                    case 1:
                        CustomerMenu customerMenu = new CustomerMenu();
                        customerMenu.readCustomer();
                        System.out.println(
                                "1. View Customer\n2. Add Customer\n3. Modify Customer\n4. Remove Customer\nEnter random key to exit");
                        openMenu(customerMenu);
                        customerMenu.updateCustomer();
                        break;

                    case 2:
                        ArtistMenu artistMenu = new ArtistMenu();
                        artistMenu.readArtist();
                        System.out.println(
                                "1. View Artist\n2. Add Artist\n3. Modify Artist\n4. Remove Artist\nEnter random key to exit");
                        openMenu(artistMenu);
                        artistMenu.updateArtist();
                        break;

                    case 3:
                        ArtworkPurchaseMenu artworkMenu = new ArtworkPurchaseMenu();
                        artworkMenu.readArtwork();
                        System.out.println(
                                "1. View Artwork\n2.Add Artwork\n3.Modify Artwork\n4.Remove Artwork\nEnter random key to exit");
                        openMenu(artworkMenu);
                        artworkMenu.updateArtwork();
                        break;

                    case 4:
                        resetAccount();
                        break;

                    case 5:
                        login = false;

                    default:
                        System.out.println("Invalid Option.");
                        validOption = false;
                }
            } while (validOption);
        }
    }

    public static boolean loginAccount() {
        File file = new File("OwnerAccount.txt");
        String name = "0";
        String password = "0";
        boolean isRead = false;
        try {
            Scanner infile = new Scanner(file);
            name = infile.nextLine();
            password = infile.nextLine();
            isRead = true;
        } catch (Exception ex) {
            System.out.println(ex);
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter Password: ");
        String loginPassword = input.nextLine();

        if (username.equals(name) && loginPassword.equals(password) && isRead) {
            System.out.println("Login successfully");
            return true;
        } else
            return false;
    }

    public static void resetAccount() {
        File file = new File("OwnerAccount.txt");
        String username = "0";
        String loginPassword = "0";
        Scanner input = new Scanner(System.in);
        try {
            PrintWriter outfile = new PrintWriter(file);
            System.out.print("Enter new username: ");
            username = input.nextLine();
            System.out.print("Enter new password: ");
            loginPassword = input.nextLine();
            outfile.println(username + "\n" + loginPassword);
            outfile.close();
            System.out.println("Account reset successfully");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void openMenu(AdminMenu menu) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter choice: ");
        int choice = -1;
        boolean validChoice = false;
        do {
            try {
                choice = Integer.parseInt(input.nextLine());
                validChoice = true;
            } catch (Exception ex) {
                System.out.println("Invalid Choice.");
            }
        } while (!validChoice);

        if (choice == 1)
            menu.viewInfo();
        else if (choice == 2)
            menu.addInfo();
        else if (choice == 3)
            menu.modifyInfo();
        else if (choice == 4)
            menu.removeInfo();
        else if (choice == 5)
            System.out.println("Exit successfully");
        else
            System.out.println("Invalid Choice.");

    }
}