import java.util.*;
import java.util.zip.Inflater;
import java.io.File;
import java.io.PrintWriter;

public class ArtworkPurchaseMenu extends AdminMenu {

    private ArrayList<Artwork> artworks = new ArrayList<Artwork>();

    public void readArtwork() {
        try {
            Scanner infile = new Scanner(new File("Artwork.txt"));

            while (infile.hasNextLine()) {
                String title = infile.nextLine();
                String datePurchased = infile.nextLine();
                String dateSold = infile.nextLine();

                String name = infile.nextLine();
                int age = Integer.parseInt(infile.nextLine());
                String specialty = infile.nextLine();
                String status = infile.nextLine();
                String priceRange = infile.nextLine();
                Artist artist = new Artist(name, age, specialty, status, priceRange);

                boolean isSold = Boolean.parseBoolean(infile.nextLine());

                artworks.add(new Artwork(title, datePurchased, dateSold, artist, isSold));
            }
            infile.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void updateArtwork() {
        try {
            PrintWriter outfile = new PrintWriter("Artwork.txt");

            for (Artwork artwork : artworks) {
                outfile.println(artwork.getTitle().toUpperCase() + "\n" +
                artwork.getDatePurchased().toUpperCase() + "\n" + 
                artwork.getDateSold().toUpperCase() + "\n" +
                artwork.getArtist().getName().toUpperCase() + "\n" + artwork.getArtist().getAge() + "\n"
                        + artwork.getArtist().getSpecialty().toUpperCase() + "\n" + artwork.getArtist().getStatus().toUpperCase() + "\n"
                        + artwork.getArtist().getPriceRange() + "\n" + artwork.getIsSold());
            }
            outfile.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void viewInfo() {
        System.out.println("\t\tArtwork List");
        System.out.println("_____________________________________________\n");
        for (int i = 0; i < artworks.size(); i++) {
            System.out.println("\nArtwork " + (i + 1));
            System.out.println("_____________________");
            System.out.println("Title: " + artworks.get(i).getTitle());
            System.out.println("Artist: " + artworks.get(i).getArtist().getName());
            System.out.println("Purchasing Date: " + artworks.get(i).getDatePurchased());
            if (artworks.get(i).getIsSold()) {
                System.out.println("Status: Sold");
                System.out.println("Sold Date: " + artworks.get(i).getDateSold());
            }
            else
                System.out.println("Status: Unsold");
        }
        System.out.println();
    }

    @Override
    public void addInfo() {
        System.out.println("\t\tArtwork Registration");
        System.out.println("_____________________________________________");
        Scanner input = new Scanner(System.in);

        boolean exist = false;

        System.out.print("Enter Artwork Title: ");
        String title = input.nextLine();

        for (int i = 0; i < artworks.size(); i++) {
            if (title.equalsIgnoreCase(artworks.get(i).getTitle())) {
                exist = true;
            }
        }

        if (!exist) {
            String status;
            do {
                System.out.print("Enter Artwork Status (Sold/Unsold): ");
                status = input.nextLine();
                if (!status.equalsIgnoreCase("SOLD") && !status.equalsIgnoreCase("UNSOLD"))
                    System.out.println("Invalid Data Entered.");
            } while (!status.equalsIgnoreCase("SOLD") && !status.equalsIgnoreCase("UNSOLD"));
            boolean isSold;
            if (status.equalsIgnoreCase("SOLD"))
                isSold = true;
            else
                isSold = false;

            boolean validDate = false;
            String datePurchased = "INVALID";
            String dateSold = "INVALID";
            int pYear = 0;
            int pMonth = 0;
            int pDay = 0;
            int sYear = 0;
            int sMonth = 0;
            int sDay = 0;           
            do {
                try {
                    System.out.print("Enter Purchasing Year: ");
                    pYear = Integer.parseInt(input.nextLine());
        
                    System.out.print("Enter Purchasing Month: ");
                    pMonth = Integer.parseInt(input.nextLine());            
                    
                    System.out.print("Enter Purchasing Day: ");
                    pDay = Integer.parseInt(input.nextLine());
                    validDate = true;

                    if (isSold) {
                        validDate = false;
            
                        System.out.print("Enter Sold Year: ");
                        sYear = Integer.parseInt(input.nextLine());
            
                        System.out.print("Enter Sold Month: ");
                        sMonth = Integer.parseInt(input.nextLine());          
                        
                        System.out.print("Enter Sold Day: ");
                        sDay = Integer.parseInt(input.nextLine());
            
                        if (pYear > sYear)
                            System.out.println("Invalid Date Entered.");
                        else
                            if (pMonth > sMonth)
                                System.out.println("Invalid Date Entered.");
                            else
                                if (pDay > sDay)
                                    System.out.println("Invalid Date Entered.");
                                else {
                                    validDate = true;
                                    datePurchased = pDay + "/" + pMonth + "/" + pYear;
                                    dateSold = sDay + "/" + sMonth + "/" + sYear;
                                }
                    }
                } catch (Exception ex) {
                    System.out.println("Invalid Date Entered");
                }
            } while (!validDate);

            Artist artist = inputArtist();


            artworks.add(new Artwork(title, datePurchased, dateSold, artist, isSold));
            System.out.println("Artwork registered successfully.");
        } else
            System.out.println("Artwork already registered.");
    }

    @Override
    public void removeInfo() {
        System.out.println("\t\tArtwork Deletion");
        System.out.println("_____________________________________________");
        Scanner input = new Scanner(System.in);

        System.out.print("Enter artwork name to be remove: ");
        String title = input.nextLine();

        for (int i = 0; i < artworks.size(); i++) {
            if (title.equalsIgnoreCase(artworks.get(i).getTitle())) {
                artworks.remove(i);
                System.out.println("Artwork removed from record successfully.");
                i = artworks.size();
            }
        }
    }

    @Override
    public void modifyInfo() {
        System.out.println("\t\tArtwork Information Update");
        System.out.println("_____________________________________________");

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Artwork Title: ");
        String title = input.nextLine();

        boolean registered = false;
        for (int i = 0; i < artworks.size(); i++) {
            if (title.equalsIgnoreCase(artworks.get(i).getTitle())) {
                registered = true;
                artworks.remove(i);
                i = artworks.size();

                String status;
                do {
                    System.out.print("Enter Artwork Status (Sold/Unsold): ");
                    status = input.nextLine();
                    if (!status.equalsIgnoreCase("SOLD") && !status.equalsIgnoreCase("UNSOLD"))
                        System.out.println("Invalid Data Entered.");
                } while (!status.equalsIgnoreCase("SOLD") && !status.equalsIgnoreCase("UNSOLD"));
                boolean isSold;
                if (status.equalsIgnoreCase("SOLD"))
                    isSold = true;
                else
                    isSold = false;
    
                boolean validDate = false;
                String datePurchased = "INVALID";
                String dateSold = "INVALID";
                int pYear = 0;
                int pMonth = 0;
                int pDay = 0;
                int sYear = 0;
                int sMonth = 0;
                int sDay = 0;           
                do {
                    try {
                        System.out.print("Enter Purchasing Year: ");
                        pYear = Integer.parseInt(input.nextLine());
            
                        System.out.print("Enter Purchasing Month: ");
                        pMonth = Integer.parseInt(input.nextLine());            
                        
                        System.out.print("Enter Purchasing Day: ");
                        pDay = Integer.parseInt(input.nextLine());
                        validDate = true;
    
                        if (isSold) {
                            validDate = false;
                
                            System.out.print("Enter Sold Year: ");
                            sYear = Integer.parseInt(input.nextLine());
                
                            System.out.print("Enter Sold Month: ");
                            sMonth = Integer.parseInt(input.nextLine());          
                            
                            System.out.print("Enter Sold Day: ");
                            sDay = Integer.parseInt(input.nextLine());
                
                            if (pYear > sYear)
                                System.out.println("Invalid Date Entered.");
                            else
                                if (pMonth > sMonth)
                                    System.out.println("Invalid Date Entered.");
                                else
                                    if (pDay >= sDay)
                                        System.out.println("Invalid Date Entered.");
                                    else {
                                        validDate = true;
                                        datePurchased = pDay + "/" + pMonth + "/" + pYear;
                                        dateSold = sDay + "/" + sMonth + "/" + sYear;
                                    }
                        }
                    } catch (Exception ex) {
                        System.out.println("Invalid Date Entered");
                    }
                } while (!validDate);
    
                Artist artist = inputArtist();
                artworks.add(new Artwork(title, datePurchased, dateSold, artist, isSold));
                System.out.println("Artwork information updated successfully.");
            }
        }
        if (!registered)
            System.out.println("Artwork is not register yet.");
    }

    public Artist inputArtist()
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Artist Name: ");
        String name = input.nextLine();

            int age = 0;
            do {
                try {
                    System.out.print("Enter Artist Age: ");
                    age = Integer.parseInt(input.nextLine());
                } catch (Exception ex) {
                    System.out.println("Artist age must larger than 0.");
                }
            } while (age <= 0);

            System.out.print("Enter Artist Specialty: ");
            String specialty = input.nextLine();

            String status;
            do {
                System.out.print("Enter Status (Alive/Deceased): ");
                status = input.nextLine();

                if (!status.equalsIgnoreCase("ALIVE") && !status.equalsIgnoreCase("Deceased")) {
                    System.out.println("Artist Status should be <ALIVE> or <DECEASED> only.");
                }
            } while (!status.equalsIgnoreCase("ALIVE") && !status.equalsIgnoreCase("Deceased"));

            boolean validRange = false;
            String priceRange = "0";
            double min = -1;
            double max = -1;
            do {
                do {
                    try {
                        System.out.print("Enter Artwork Minimum Price: ");
                        min = Double.parseDouble(input.nextLine());
                        System.out.print("Enter Artwork Maximum Price: ");
                        max = Double.parseDouble(input.nextLine());
                        priceRange = min + "-" + max;
                        validRange = true;
                    } catch (Exception ex) {
                        System.out.println("INVALID INPUT.");
                    }
                } while (!validRange);
            } while (min < 0 || max < 0 || max < min);

        return new Artist(name, age, specialty, status, priceRange);
    }
}