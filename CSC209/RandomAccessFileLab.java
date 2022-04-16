import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import java.util.*;

public class RandomAccessFileLab {// Write or add song into the file
    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("song.dat", "rw");
            Song s1 = new Song(101, "Last Friday Night", "Pop", 3.20, "Katy Perry");
            Song s2 = new Song(102, "Habibi", "EDM", 4.52, "IDK who");

            System.out.println(s1.getTitle() + " " + s1.getArtist());
            System.out.println(s2.getTitle() + " " + s2.getArtist());

            raf.writeInt(s1.getId());
            byte[] title = new byte[20];
            title = s1.getTitle().concat("                    ").getBytes();
            raf.write(title, 0, 20);

            byte[] genre = new byte[10];
            genre = s1.getGenre().concat("          ").getBytes();
            raf.write(genre, 0, 10);

            raf.writeDouble(s1.getDuration());

            byte[] artist = new byte[20];
            artist = s1.getArtist().concat("                    ").getBytes();
            raf.write(artist, 0, 20);

            raf.writeInt(s2.getId());
            title = new byte[20];
            title = s2.getTitle().concat("                    ").getBytes();
            raf.write(title, 0, 20);

            genre = new byte[10];
            genre = s2.getGenre().concat("          ").getBytes();
            raf.write(genre, 0, 10);

            raf.writeDouble(s2.getDuration());

            artist = new byte[20];
            artist = s2.getArtist().concat("                    ").getBytes();
            raf.write(artist, 0, 20);

            System.out.println(raf.getFilePointer());
            raf.seek(4);
            raf.read(title, 0, 20);
            System.out.println(new String(title));
            // duration of the last song is at 4+20+10 = 34 bytes
            raf.seek(34);
            double songDuration = raf.readDouble();
            System.out.println(songDuration);

            // duration of the 2nd song is at 60+34 = 94 bytes
            raf.seek(96);
            songDuration = raf.readDouble();
            System.out.println(songDuration);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
