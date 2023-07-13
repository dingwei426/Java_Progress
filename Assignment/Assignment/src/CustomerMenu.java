import java.util.*;
import java.io.File;
import java.io.PrintWriter;

public class CustomerMenu extends AdminMenu {

    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public void readCustomer() {
        try {
            Scanner infile = new Scanner(new File("Customer.txt"));

            while (infile.hasNextLine()) {
                String name = infile.nextLine();
                int age = Integer.parseInt(infile.nextLine());
                String contactNum = infile.nextLine();
                String artistPreference = infile.nextLine();
                String[] artworkPurchases = infile.nextLine().split(",");
                customers.add(new Customer(name, age, contactNum, artistPreference, artworkPurchases));
            }
            infile.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void updateCustomer() {
        try {
            PrintWriter outfile = new PrintWriter("Customer.txt");

            for (Customer customer : customers) {
                outfile.println(customer.getName().toUpperCase() + "\n" + customer.getAge() + "\n"
                        + customer.getContactNum() + "\n" + customer.getArtistPreference().toUpperCase() + "\n"
                        + String.join(",", customer.getArtworkPurchase()).toUpperCase());
            }
            outfile.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void viewInfo() {
        System.out.println("\t\tCustomer List");
        System.out.println("_____________________________________________\n");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println("\nCustomer " + (i+1));
            System.out.println("_____________________");
            System.out.println("Name: " + customers.get(i).getName());
            System.out.println("Age: " + customers.get(i).getAge());
            System.out.println("Contact Number: " + customers.get(i).getContactNum());
            System.out.println("Artist Preference: " + customers.get(i).getArtistPreference());
            System.out.print("Artwork Purchases: ");
            for (int j = 0; j < customers.get(i).getArtworkPurchase().length; j++) {
                if (j != customers.get(i).getArtworkPurchase().length-1)
                    System.out.print(customers.get(i).getArtworkPurchase()[j] + ", ");
                else
                    System.out.println(customers.get(i).getArtworkPurchase()[j]);

            }
            System.out.println();
        }
    }

    @Override
    public void addInfo() {
        System.out.println("\t\tCustomer Registration");
        System.out.println("_____________________________________________");
        Scanner input = new Scanner(System.in);

        boolean exist = false;

        System.out.print("Enter Customer Name: ");
        String name = input.nextLine();

        for (int i = 0; i < customers.size(); i++) {
            if (name.equalsIgnoreCase(customers.get(i).getName())) {
                exist = true;
            }
        }

        if (!exist) {
            int age = 0;
            do {
                try {
                    System.out.print("Enter Customer age: ");
                    age = Integer.parseInt(input.nextLine());
                }
                catch (Exception ex)
                {
                    System.out.println("Customer age must larger than 0.");
                }
            } while (age <= 0);


            System.out.print("Enter Customer Contact Number: ");
            String contactNum = input.nextLine();

            System.out.print("Enter Customer Preferred Artist(Enter <NO> if no prefered artist): ");
            String artistPreference = input.nextLine();
            if (artistPreference.equalsIgnoreCase("NO"))
                artistPreference = "NO PREFERRED ARTIST";

            int num = 0;
            do {
                System.out.print("Enter number of artwork purchases: ");
                num = Integer.parseInt(input.nextLine());
                if (num == 0)
                    System.out.print("Number of artwork purchases should not be less than 1.\nPlease re-enter the number.");
            } while (num <= 0);

            String[] artworkPurchases = new String[num];
    
            for (int j = 0; j < num; j++) {
                System.out.printf("Enter Artwork Purchase %d: ", j + 1);
                artworkPurchases[j] = input.nextLine();
            }             
            customers.add(new Customer(name, age, contactNum, artistPreference, artworkPurchases));
            System.out.println("Customer registered successfully.");

        }
        else
            System.out.println("Customer already registered.");

    }

    @Override
    public void removeInfo() {
        System.out.println("\t\tCustomer Deletion");
        System.out.println("_____________________________________________");
        Scanner input = new Scanner(System.in);

        System.out.print("Enter customer name to be remove: ");
        String name = input.nextLine();

        for (int i = 0; i < customers.size(); i++) {
            if (name.equalsIgnoreCase(customers.get(i).getName())) {
                customers.remove(i);
                System.out.println("Customer removed from record successfully.");
                i = customers.size();
            }
        }
    }

    @Override
    public void modifyInfo() {
        System.out.println("\t\tCustomer Information Update");
        System.out.println("_____________________________________________");

        Scanner input = new Scanner(System.in);

        System.out.print("Enter customer name to be modified: ");
        String name = input.nextLine();

        boolean registered = false;
        for (int i = 0; i < customers.size(); i++) {
            if (name.equalsIgnoreCase(customers.get(i).getName())) 
            {
                customers.remove(i);
                i = customers.size();
                registered = true;

                int age = 0;
                do {
                    try {
                        System.out.print("Enter Customer age: ");
                        age = Integer.parseInt(input.nextLine());
                    }
                    catch (Exception ex)
                    {
                        System.out.println("Customer age must larger than 0.");
                    }
                } while (age <= 0);
    
                System.out.print("Enter Customer Contact Number: ");
                String contactNum = input.nextLine();
    
                System.out.print("Enter Customer Preferred Artist(Enter <NO> if no prefered artist): ");
                String artistPreference = input.nextLine();
    
                int num = 0;
                do {
                    System.out.print("Enter number of artwork purchases: ");
                    num = Integer.parseInt(input.nextLine());
                    if (num == 0)
                        System.out.print("Number of artwork purchases should not be less than 1.\nPlease re-enter the number.");
                } while (num <= 0);
    
                String[] artworkPurchases = new String[num];
        
                for (int j = 0; j < num; j++) {
                    System.out.printf("Enter Artwork Purchase %d: ", j + 1);
                    artworkPurchases[j] = input.nextLine();
                }             
                customers.add(new Customer(name, age, contactNum, artistPreference, artworkPurchases));
                System.out.println("Customer Information updated successfully.");
            }
        }
        if (!registered)
            System.out.println("Customer is not register yet.");
    }
}
