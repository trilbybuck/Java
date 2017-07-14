public class Factorial{
	
	public static void main(String[]args){
		
		//some examples that use the methods
		//System.out.println(choose(5,6));
		//System.out.println(factorial(0));

	}

	//calculates factorial
	public static int factorial(int n){
		int fac = 1; 
		for(int i=1; i<=n; i++){
			fac *= i;
		}
		return fac;
	}

	//using factorial, calculates combinations
	public static int choose(int n, int k){
		int num = factorial(n)/ (factorial(k)*factorial(n-k));
		return num;
	}
}