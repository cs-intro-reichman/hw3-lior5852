// Computes the periodical payment necessary to pay a given loan.

public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {	
		// Replace the following statement with your code
		double balance = loan;
		for( int i = 0; i < n ; i ++ ) {
			balance = balance - payment;
			balance = balance * (1 + rate/100);
		}
		return balance;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		// Replace the following statement with your code
		double payment = loan / n;
		iterationCounter = 0;
		double balance = endBalance(loan, rate, n, payment);

		while ( balance > 0 ) {

			iterationCounter ++;
			payment = payment + epsilon;
			balance = endBalance(loan, rate, n, payment);
		}
		return payment;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        // Replace the following statement with your code
		    // נקודת התחלה נמוכה (תשלום קטן מדי => היתרה חיובית)
    double low = loan / n;

    // נקודת התחלה גבוהה (תשלום עצום => היתרה שלילית)
    double high = loan;

    // איפוס מונה האיטרציות
    iterationCounter = 0;

    // נחשב את balance עבור low
    double balLow = endBalance(loan, rate, n, low);

    // נחשב את balance עבור high
    double balHigh = endBalance(loan, rate, n, high);

    // כל עוד הטווח בין high ל-low גדול מ-epsilon
    while (high - low > epsilon) {

        iterationCounter++;

        double mid = (low + high) / 2.0;   // תשלום באמצע
        double balMid = endBalance(loan, rate, n, mid);

        // אם balMid ו-balLow באותו סימן → הפתרון בין mid ל-high
        if (balMid > 0 && balLow > 0) {
            low = mid;
            balLow = balMid;
        } 
        else {
            high = mid;
            balHigh = balMid;
        }
    }
		return (low + high) / 2.0;
    }
}