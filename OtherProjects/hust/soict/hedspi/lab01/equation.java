package hust.soict.hedspi.lab01;

import javax.swing.JOptionPane;

public class equation {
    public static void main(String[] args) {
        String option;
        option = JOptionPane.showInputDialog(null, "(1): Phuong trinh bac nhat 1 an\n(2): He phuong trinh bac nhat 2 an\n(3): Phuong trinh bac hai 1 an.", "Input the option", JOptionPane.INFORMATION_MESSAGE);
        
        if (option == null) {
            System.exit(0);
        }

        int optionNum = Integer.parseInt(option);
        
        switch (optionNum) {
            case 1:
                String s1_a = JOptionPane.showInputDialog(null, "Nhap he so bac nhat a: ", "Nhap he so bac nhat", JOptionPane.INFORMATION_MESSAGE);
                String s1_b = JOptionPane.showInputDialog(null, "Nhap he so tu do b: ", "Nhap he so tu do", JOptionPane.INFORMATION_MESSAGE);
                double a1 = Double.parseDouble(s1_a);
                double b1 = Double.parseDouble(s1_b);
                
                if (a1 == 0) {
                    if (b1 == 0) {
                        System.out.println("Phuong trinh co vo so nghiem");
                    } else {
                        System.out.println("Phuong trinh vo nghiem");
                    }
                } else {
                    double root = -b1 / a1;
                    System.out.println("Phuong trinh co nghiem duy nhat: " + root);
                }
                break;

            case 2:
                double a2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhap he so a: ", "Nhap he so", JOptionPane.INFORMATION_MESSAGE));
                double b2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhap he so b:", "Nhap he so", JOptionPane.INFORMATION_MESSAGE));
                double c2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhap he so c:", "Nhap he so", JOptionPane.INFORMATION_MESSAGE));
                double d2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhap he so d: ", "Nhap he so", JOptionPane.INFORMATION_MESSAGE));
                double e2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhap he so e: ", "Nhap he so", JOptionPane.INFORMATION_MESSAGE));
                double f2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhap he so f: ", "Nhap he so", JOptionPane.INFORMATION_MESSAGE));
                
                double D = a2 * e2 - d2 * b2;
                double D1 = c2 * e2 - f2 * b2;
                double D2 = a2 * f2 - d2 * c2;
                
                if (D == 0) {
                    if (D1 != 0 || D2 != 0) {
                        System.out.println("He phuong trinh vo nghiem");
                    } else {
                        System.out.println("He phuong trinh co vo so nghiem");
                    }
                } else {
                    System.out.println("X = " + (D1 / D));
                    System.out.println("Y = " + (D2 / D));
                }
                break;

            case 3:
                double a3 = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhap he so bac hai a: ", "Nhap he so ", JOptionPane.INFORMATION_MESSAGE));
                double b3 = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhap he so bac nhat b: ", "Nhap he so ", JOptionPane.INFORMATION_MESSAGE));
                double c3 = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhap he so tu do: ", "Nhap he so ", JOptionPane.INFORMATION_MESSAGE));
                
                if (a3 == 0) {
                    if (b3 == 0) {
                        if (c3 == 0) System.out.println("Phuong trinh co vo so nghiem");
                        else System.out.println("Phuong trinh vo nghiem");
                    } else {
                        System.out.println("Phuong trinh co nghiem: " + (-c3 / b3));
                    }
                } else {
                    double delta = b3 * b3 - 4 * a3 * c3;
                    if (delta < 0) {
                        System.out.println("Phuong trinh vo nghiem");
                    } else if (delta == 0) {
                        System.out.println("Phuong trinh co nghiem kep: " + (-b3 / (2 * a3)));
                    } else {
                        double x1 = (-b3 + Math.sqrt(delta)) / (2 * a3);
                        double x2 = (-b3 - Math.sqrt(delta)) / (2 * a3);
                        System.out.println("Phuong trinh co 2 nghiem phan biet: " + x1 + " va " + x2);
                    }
                }
                break;
        }
        System.exit(0);
    }
}

