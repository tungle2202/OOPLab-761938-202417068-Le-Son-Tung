package hust.soict.hedspi.lab01.JavaBasics.src;

import java.util.Arrays;
import java.util.Scanner;

public class arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        double[] numbers = new double[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            numbers[i] = sc.nextDouble();
        }

        Arrays.sort(numbers);

        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        double average = sum / n;

        System.out.println("Sorted Array: " + Arrays.toString(numbers));
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average value: " + average);

        sc.close();
    }
}