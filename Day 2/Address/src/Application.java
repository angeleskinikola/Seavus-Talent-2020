import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        boolean quit = false;

        while (!quit) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter street:");
            String street = scanner.nextLine();

            System.out.println("Enter street number:");
            int streetNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter city:");
            String city = scanner.nextLine();

            System.out.println("Enter zip code:");
            int zipCode = scanner.nextInt();
            scanner.nextLine();

            try {
                Address address = new Address(street, streetNumber, city, zipCode);
                System.out.println(address.toString());
            } catch (ZipCodeException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Enter new address? y/n");
            if (scanner.nextLine().trim().equals("y")) {
                continue;
            } else {
                quit = true;
            }
        }


    }
}
