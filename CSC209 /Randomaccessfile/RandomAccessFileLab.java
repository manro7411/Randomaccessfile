
/**
 * RandomAccessFileLab
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public class RandomAccessFileLab {

    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("song.dat", "rw");
            Song s1 = new Song(111, "Lsat Friday night", "Pop", 3.20, "Karry Perry");
            System.out.println(s1.getTitle() + " " + s1.getArtist());
            Song s2 = new Song(102, "The Black hawk War", "Rap", 4.52, "Sufjan Stevans");
            System.out.println(s2.getTitle() + " " + s2.getArtist());

            raf.writeInt(s1.getId());

            // set the size of title
            byte[] title = new byte[20];
            title = s1.getTitle().concat("                   ").getBytes();
            raf.write(title, 0, 20);

            // set the size of genre
            byte[] genre = new byte[10];
            genre = s1.getGenre().concat("          ").getBytes();
            raf.write(genre, 0, 10);

            // write double
            raf.writeDouble(s1.getDuration());

            // fix the size of artist
            byte[] artist = new byte[20];
            artist = s1.getArtist().concat("                   ").getBytes();
            raf.write(title, 0, 20);

            // s2
            title = s2.getTitle().concat("                   ").getBytes();
            raf.write(title, 0, 20);
            genre = s2.getGenre().concat("          ").getBytes();
            raf.write(genre, 0, 10);
            raf.writeDouble(s2.getDuration());
            artist = s2.getArtist().concat("                   ").getBytes();
            raf.write(title, 0, 20);

            // check the position of the final process
            System.out.println(raf.getFilePointer());
            raf.seek(4);// jump to the position
            raf.read(title, 0, 20);
            System.out.println(new String(title));

            // duration of the first song(4+20+10 = 34bytes)

            raf.seek(34);// jump to the position
            double songduration = raf.readDouble();
            System.out.println("The length = " + songduration);

            // furation of the second song (62+34 = 96 byte) 60 is the s1 >> double is 8
            // byte not 6 byte
            raf.seek(96);
            double songduration2 = raf.readDouble();
            System.out.println("The length = " + songduration2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}