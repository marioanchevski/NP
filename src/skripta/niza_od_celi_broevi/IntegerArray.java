package skripta.niza_od_celi_broevi;

import java.util.Arrays;

public final class IntegerArray {

    private int[] a;

    public IntegerArray(int[] a) {
        this.a = Arrays.copyOf(a, a.length);
    }

    private IntegerArray(int[] a, boolean to_copy) {
        if (to_copy)
            this.a = a;
        else
            this.a = Arrays.copyOf(a, a.length);
    }

    public int length() {
        return a.length;
    }

    public int getElementAt(int i) {
        return a[i];
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < a.length; i++)
            sum += a[i];
        return sum;
    }

    public double average() {
        return sum() * 1.0 / length();
    }

    public IntegerArray getSorted() {
        int sorted_a[] = Arrays.copyOf(a, length());
        Arrays.sort(sorted_a);
        return new IntegerArray(sorted_a);
    }

    public IntegerArray concat(IntegerArray ia) {
        int[] result = new int[ia.a.length + a.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(ia.a, 0, result, a.length, ia.a.length);
        return new IntegerArray(result, true);
    }

    public String toString() {
        return Arrays.toString(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerArray that = (IntegerArray) o;
        return Arrays.equals(a, that.a);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(a);
    }
}
