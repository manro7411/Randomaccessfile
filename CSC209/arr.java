import java.util.Scanner;

public class arr {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        int[] array = new int[num];

        for (int i = 0; i < array.length; i++) {
            array[i] = kb.nextInt();

        }
        for (int j = 0; j < array.length; j++) {
            array[1] = 20;
            array[0] = array[j] + array[2];
            System.out.print(array[j] + " ");

        }

    }

}
