// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// Replace the following statement with your code
		int total = x1;
		int i = 0;
		if ( x2 > 0 )
			while (i < x2){
				total ++;
				i ++;
		}
		else {
			while(i >x2) {
				total -- ;
				i -- ;
			}
		}
		return total;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
		int totally = x1;
		int i = 0;
		if ( x2 > 0)
			while (i < x2) {
				totally --;
				i ++;
		}
		else {
			while (i > x2) {
				totally ++;
				i --;
			}
		}
		return totally;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// Replace the following statement with your code
		int total = 0;
		int i = 0;
		if ( x2 > 0)
			while (i < x2) {
				total = plus(total, x1) ;
				i ++;
		}
		else {
			while ( i > x2) {
				total = plus(total, x1);
				i -- ;
			}
		total = minus(0, total);
		}
		return total;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Replace the following statement with your code
		int total = 1;
		int i = 0;
		while (i < n) {
			total = times(total, x);
			i ++;
		}
		return total;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// Replace the following statement with your code
		int count = 0;
		int a = x1;
		int b = x2;

		if (a < 0 ) {
			a = minus(0, a);
		}
		if ( b < 0){
			b = minus(0, b);

		}
			while ( a >= b) {
				a= minus(a, b);
				count++ ;
		}
   		 if ((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0)) {
        count = minus(0, count);
   		 }
		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// Replace the following statement with your code
		while (x1 >= x2) {
			x1 = x1 - x2;
		}
		return x1;
	}

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// Replace the following statement with your code
		int a = 1;

		while (x >= times(a, a)) {
			a ++ ;
		}
		return a -1 ;	
	}	  	  
}