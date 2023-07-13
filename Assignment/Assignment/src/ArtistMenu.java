import java.util.*;
import java.io.File;
import java.io.PrintWriter;

public class ArtistMenu extends AdminMenu {

    private ArrayList<Artist> artists = new ArrayList<Artist>();

    public void readArtist() {
        try {
            Scanner infile = new Scanner(new File("Artist.txt"));

            while (infile.hasNextLine()) {
                String name = infile.nextLine();
                int age = Integer.parseInt(infile.nextLine());
                String specialty = infile.nextLine();
                String status = infile.nextLine();
                String priceRange = infile.nextLine();
                artists.add(new Artist(name, age, specialty, status, priceRange));
            }
            infile.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void updateArtist() {
        try {
            PrintWriter outfile = new PrintWriter("Artist.txt");

            for (Artist artist : artists) {
                outfile.println(artist.getName().toUpperCase() + "\n" + artist.getAge() + "\n"
                        + artist.getSpecialty().toUpperCase() + "\n" + artist.getStatus().toUpperCase() + "\n"
                        + artist.getPriceRange());
            }
            outfile.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void viewInfo() {
        System.out.println("\t\tArtist List");
        System.out.println("_____________________________________________\n");
        for (int i = 0; i < artists.size(); i++) {
            System.out.println("\nArtist " + (i + 1));
            System.out.println("_____________________");
            System.out.println("Name: " + artists.get(i).getName());
            System.out.println("Age: " + artists.get(i).getAge());
            System.out.println("Specialty: " + artists.get(i).getSpecialty());
            System.out.println("Status: " + artists.get(i).getStatus());
            System.out.println("Price Range of Artwork: " + artists.get(i).getPriceRange());
        }
        System.out.println();
    }

    @Override
    public void addInfo() {
        System.out.println("\t\tArtist Registration");
        System.out.println("_____________________________________________");
        Scanner input = new Scanner(System.in);

        boolean exist = false;

        System.out.print("Enter Artist Name: ");
        String name = input.nextLine();

        for (int i = 0; i < artists.size(); i++) {
            if (name.equalsIgnoreCase(artists.get(i).getName())) {
                exist = true;
            }
        }

        if (!exist) {
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

            artists.add(new Artist(name, age, specialty, status, priceRange));
            System.out.println("Artist registered successfully.");
        } else
            System.out.println("Artist already registered.");
    }

    @Override
    public void removeInfo() {
        System.out.println("\t\tArtist Deletion");
        System.out.println("_____________________________________________");
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Artist name to be remove: ");
        String name = input.nextLine();

        for (int i = 0; i < artists.size(); i++) {
            if (name.equalsIgnoreCase(artists.get(i).getName())) {
                artists.remove(i);
                System.out.println("Artist removed from record successfully.");
                i = artists.size();
            }
        }
    }

    @Override
    public void modifyInfo() {
        System.out.println("\t\tArtist Information Update");
        System.out.println("_____________________________________________");

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Artist name to be modified: ");
        String name = input.nextLine();

        boolean registered = false;
        for (int i = 0; i < artists.size(); i++) {
            if (name.equalsIgnoreCase(artists.get(i).getName())) {
                artists.remove(i);
                i = artists.size();
                registered = true;

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
    
                artists.add(new Artist(name, age, specialty, status, priceRange));
                System.out.println("Artist information updated successfully.");
            }
        }
        if (!registered)
            System.out.println("Artist is not register yet.");
    }
}