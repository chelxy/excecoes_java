package application;
//Tratando ArithmeticExceptions e InputMismatchExceptions.

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByZeroNoExceptionHandling {

	// demonstra o lan�amento de uma exce��o quando ocorre uma divis�o por zero
	public static int quotient(int numerator, int denominator) throws ArithmeticException{
		return numerator / denominator; // poss�vel divis�o por zero
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		boolean continueLoop = true; // determina se mais entradas s�o necess�rias
		
		do {
			try {// l� dois n�meros e calcula o quociente
				System.out.print("Please enter an integer numerator: ");
				int numerator = scanner.nextInt();
				System.out.print("Please enter an integer denominator: ");
				int denominator = scanner.nextInt();
				
				int result = quotient(numerator, denominator);
				System.out.printf("%nResult: %d / %d = %d%n", numerator, denominator, result);
				continueLoop = false; // entrada bem sucedida; fim do loop.
			}
			catch (InputMismatchException e) {
				System.err.printf("%nException: %s%n", e);
				scanner.nextLine();	// descarta entrada para o ususrio tentar de novo
				System.out.printf("You must enter integers. Please try again.%n%n");
			}
			catch(ArithmeticException e) {
				System.err.printf("%nException: %s%n", e);
				System.out.printf("Zero is an invalid denominator. Please try again.%n%n");
			}
			
		} while(continueLoop);
		
		
		scanner.close();
	}

}
