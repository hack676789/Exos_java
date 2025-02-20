public class IterativeFibonacci {

	public static void fibonacci(int MAX) {

		int firstNumber = 0;
		int secondNumber = 1;
		int fibonacci = 0;

		System.out.print(firstNumber + " ");
		System.out.print(secondNumber + " ");

		for (int i = 2; i < MAX; i++) {

			fibonacci = firstNumber + secondNumber;
			System.out.print(fibonacci + " ");

			firstNumber = secondNumber;
			secondNumber = fibonacci;
		}
	}

	public static void main(String[] args) {

		System.out.println(" voici la suite de Fibonacci ci-dessous");
		int MAX = 10;
		fibonacci(MAX);

	}
}

