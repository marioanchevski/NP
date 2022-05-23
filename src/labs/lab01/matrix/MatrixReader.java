package labs.lab01.matrix;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class MatrixReader{
    public static DoubleMatrix read(InputStream input) throws InsufficientElementsException {
        Scanner scan = new Scanner(input);
        int m = scan.nextInt();
        int n = scan.nextInt();
        double a[] = new double[1000];
        int i =0;
        while(scan.hasNextDouble()) {
            a[i++] = scan.nextDouble();
        }
        a = Arrays.copyOf(a, i);
        return new DoubleMatrix(a, m, n);
    }
}
