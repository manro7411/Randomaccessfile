import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

/**
 * CityRandomAccessfile
 */
public class CityRandomAccessfile {
    // What is the population of hanava
    public static void main(String[] args) {
        try {
            // city_ascii ; 150
            // lat and long : double
            // country = 50 bytes
            // iso2 : standart code for the city :2 bytes
            // iso3 : 3 bytes
            // admin_name : 150 bytes
            // capital : 10bytes
            // population : int
            // id

            // 150+8+8+50+2+3+150+10+4 = 385
            // population is at 381 ;
            RandomAccessFile fPointer = new RandomAccessFile("city.dat", "rw");
            byte[] x = new byte[150];
            fPointer.read(x, 0, 150);
            System.out.println("The fist contry of record is " + new String(x));

            fPointer.seek(381);
            System.out.println("The population of Japan is " + fPointer.readInt());

            boolean notFound = true;
            int record = 0;
            while (notFound) {
                fPointer.seek(record * 385);
                fPointer.read(x, 0, 150);
                String city = new String(x);
                city = city.trim(); // remove the empty space bafore and after string out
                if (city.equalsIgnoreCase("Hanawa")) { // Hanawa
                    System.out.println("Hanawa is at the record number " + record);
                    fPointer.seek(record * 385 + 381);// population);
                    System.out.println("The population of Hanawa is " + fPointer.readInt());
                    notFound = false;

                    // What is the world population
                    // Show two cities that have the same name
                    // how many pairs of countries have the same name
                }
                record++;
            }
            record = 0;
            Vector cityList = new Vector();
            while (record * 385 < fPointer.length()) {
                fPointer.seek(record * 385);
                fPointer.read(x, 0, 150);
                String city = new String(x);
                city = city.trim();
                cityList.add(city);
                record++;
            }
            for (int i = 0; i < 10; i++) { // testing the Vector
                System.out.print(cityList.get(i) + " ");
            }
            Collections.sort(cityList);
            for (int i = 0; i < 10; i++) {
                System.out.println(cityList.get(i) + " ");

            }

            // to find two identical city name
            int count = 0;
            for (int i = 0; i < cityList.size() - 1; i++) {
                if (cityList.get(i).equals(cityList.get(i + 1))) {
                    System.out.println(cityList.get(i) + " = " + cityList.get(i + 1));
                    count++;
                }

            }
            System.out.print(count);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}