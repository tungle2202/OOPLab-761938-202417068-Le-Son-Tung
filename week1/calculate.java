import javax.swing.JOptionPane;
public class calculate{
	public static void main(String[] args){
		String strNum1, strNum2;
		strNum1 = JOptionPane.showInputDialog(null, "Input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
		strNum2 = JOptionPane.showInputDialog(null, "Input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
		double Num1 = Double.parseDouble(strNum1);
		double Num2 = Double.parseDouble(strNum2);
		System.out.println("Product: "+ String.valueOf(Num1+Num2));
		System.out.println("Difference: "+ String.valueOf(Num1-Num2));
		System.out.println("Product: "+ String.valueOf(Num1*Num2));
		System.out.println("Quotient: "+ String.valueOf(Num1/Num2));
		System.exit(0);
	}
}
