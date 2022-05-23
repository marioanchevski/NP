package labs.lab01.matrix;

import java.util.Arrays;
import java.util.Objects;

public final class DoubleMatrix {
    private final double [][] matrix;
    private int m,n;

    public DoubleMatrix(double[] a, int m, int n) throws InsufficientElementsException {
        matrix = new double[m][n];
        this.m = m;
        this.n = n;

        if (a.length<m*n)
            throw new InsufficientElementsException();
        int position = a.length - n*m;
        for (int i=0; i<m; i++){
            for (int j=0; j<n;j++){
                matrix[i][j] =  a[position++];
            }
        }
    }

    public String getDimensions(){
        return String.format("[%d x %d]",m,n);
    }

    public int rows(){
        return m;
    }

    public int columns(){
        return n;
    }

    public double maxElementAtRow(int row) throws InvalidRowNumberException {
        if (row > m || row < 1)
            throw new InvalidRowNumberException();
        double max = matrix[row-1][0];
        for (int i=0; i<columns(); i++)
            if (max<=matrix[row-1][i])
                max = matrix[row-1][i];
        return max;
    }

    public double maxElementAtColumn(int column) throws InvalidColumnNumberException {
        if (column > n || column < 1)
            throw new InvalidColumnNumberException();
        double max = matrix[0][column-1];
        for (int i=0; i<rows(); i++)
            if (max<=matrix[i][column-1])
                max = matrix[i][column-1];
        return max;
    }

    public double sum(){
        double sum = 0;
        for(int i=0;i<rows();i++){
            for(int j=0;j<columns();j++){
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public double[] toSortedArray(){
        double[] array = transformMatrix();
        double[] result = new double[array.length];
        int index = 0;
        Arrays.sort(array);
        for(int i=array.length-1;i>=0;i--){
            result[index] = array[i];
            index++;
        }

        return result;
    }

    private void swapElements(int first, int second, double[] array){
        double temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
    private double[] transformMatrix(){
        double[] result = new double[rows()*columns()];
        int index = 0;
        for(int i=0;i<rows();i++){
            for(int j=0;j<columns();j++){
                result[index++] = matrix[i][j];
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DoubleMatrix other = (DoubleMatrix) obj;
        if (!Arrays.deepEquals(matrix, other.matrix))
            return false;
        return true;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.deepHashCode(matrix);
        return result;
    }

    @Override
    public String toString() {
        String s ="";
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < columns()-1; j++) {
                s+=String.format("%.2f\t", matrix[i][j]);
            }
            s+=String.format("%.2f\n", matrix[i][columns()-1]);
        }
        s = s.substring(0, s.length()-1);
        return s;
    }
}