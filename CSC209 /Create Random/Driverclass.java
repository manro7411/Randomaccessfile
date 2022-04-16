import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Driverclass {
    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("Supermarket.txt", "rw");
            try (Scanner kb = new Scanner(System.in)) {
                System.out.println("Write the file By using 2 || Insert a new things = 1 ||Cancel = 0");
                int number = kb.nextInt();

                if (number == 2) {

                    Supermarket list1 = new Supermarket(100, "Vetgetable", "Onion", 20.00);
                    // Constructure 1
                    byte[] type = new byte[20];
                    type = list1.getType().concat("                    ").getBytes();
                    raf.write(type, 0, 20);
                    byte[] product = new byte[20];
                    product = list1.getProduct().concat("                    ").getBytes();
                    raf.write(product, 0, 20);

                    // Constructure 2
                    Supermarket list2 = new Supermarket(101, "Beverage", "Water", 10.00);
                    type = list2.getType().concat("                    ").getBytes();
                    raf.write(type, 0, 20);
                    product = list2.getProduct().concat("                    ").getBytes();
                    raf.write(product, 0, 20);

                    // Constructure 3
                    Supermarket list3 = new Supermarket(101, "Beverage", " milk ", 80.00);
                    type = list3.getType().concat("                    ").getBytes();
                    raf.write(type, 0, 20);
                    product = list3.getProduct().concat("                    ").getBytes();
                    raf.write(product, 0, 20);

                    Supermarket list4 = new Supermarket(101, "Snack", "Doritos", 30.00);
                    type = list4.getType().concat("                    ").getBytes();
                    raf.write(type, 0, 20);
                    product = list4.getProduct().concat("                    ").getBytes();
                    raf.write(product, 0, 20);

                    System.out.println(" ----- Write Success ----- ");

                } else if (number == 1) {

                    int newid = kb.nextInt();
                    if (newid == 3) {
                        int key = kb.nextInt();
                        Supermarket insertid = new Supermarket(key);
                        raf.writeInt(insertid.getId());
                    }

                    String ntype = kb.nextLine();
                    String nproduct = kb.nextLine();
                    double price = kb.nextDouble();

                    Supermarket insertfile = new Supermarket(ntype, nproduct, price);
                    byte[] nt = new byte[20];
                    nt = insertfile.getType().concat("                    ").getBytes();
                    raf.write(nt, 0, 20);
                    byte[] np = new byte[20];
                    np = insertfile.getProduct().concat("                    ").getBytes();
                    raf.write(np, 0, 20);

                    System.out.println(" ----- Write Success ----- ");
                } else {
                    System.out.println("----- Can't Write the file -----");

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
