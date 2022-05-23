package skripta.niza_od_celi_broevi;

import java.io.InputStream;
import java.util.Scanner;

public class ArrayReader {

    public static IntegerArray readIntegerArray(InputStream input) {
        Scanner scanner = new Scanner(input);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scanner.nextInt();
        scanner.close();
        return new IntegerArray(a);
    }

}
