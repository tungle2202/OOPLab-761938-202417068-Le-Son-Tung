package JavaBasics.src;

import java.util.Scanner;
public class Triangle {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        System.out.println("Nhap n: ");
        int n = user.nextInt();
        int length = 2*n - 1;
        int idk;
        int temp;
        for(int i = 0; i < n; i++){
            idk = 2*(i+1)-1;
            temp = length - (idk);
            temp /= 2;
            for(int j = 0; j< temp; j++){
                System.out.print(" ");
            }
            for(int j = 0; j< idk; j++){
                System.out.print("*");
            }
            for(int j = 0; j< temp; j++) {
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}
