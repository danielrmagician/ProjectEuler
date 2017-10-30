package rref;

public class MatrixRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		Fraction[][] matrix = new Fraction[n][n+1];
		for (int i = 1; i<=n; i++) {
			for (int j = 1; j<=n+1; j++) {
				if (j!=n+1) {
					Fraction frac = new Fraction((int)Math.pow(i, j),1);
					matrix[i-1][j-1] = frac;
				}
				else {
					matrix[i-1][j-1] = new Fraction(i*i+1,1);
				}
			}
		}
		Matrix matrx = new Matrix(matrix);
		matrx.rref();
// 		Print out matrix
		System.out.println(matrx.toString());
		
//		Print out last column of rrefed matrix
//		for (int i = 0; i < matrix.length; i++) {
//		    System.out.print(matrix[i][matrix.length] + " ");
//		    System.out.println();
//		}
//		Print out f(100)
//		double hundred=0;
//		for (int i = 0; i < matrix.length; i++) {
//			double newTerm= matrix[i][matrix.length]*Math.pow(14, i);
//			hundred = hundred + newTerm;
//		}
//		System.out.println("The value of the function at a hundred is " + hundred);
	}

}
