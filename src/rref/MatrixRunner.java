package rref;

import org.apfloat.Apint;

public class MatrixRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		Fraction[][] matrix = new Fraction[n][n+1];
		for (int i = 1; i<=n; i++) {
			for (int j = 1; j<=n+1; j++) {
				if (j!=n+1) {
					Fraction frac = new Fraction(new Apint((long) Math.pow(i, j)), Apint.ONE);
					matrix[i-1][j-1] = frac;
				}
				else {
					matrix[i-1][j-1] = new Fraction(new Apint((long) Math.pow(i, 2)+1), Apint.ONE);
				}
			}
		}
		Matrix matrx = new Matrix(matrix);
//		System.out.println(matrx.toString());
//		System.out.println();
		matrx.rref();
// 		Print out matrix
		System.out.println(matrx.toStringLast());
		
//		Print out last column of rrefed matrix
//		for (int i = 0; i < matrix.length; i++) {
//		    System.out.print(matrix[i][matrix.length] + " ");
//		    System.out.println();
//		}
//		Print out f(100)
		Fraction hundred= new Fraction(Apint.ZERO, Apint.ONE);
		for (int i = 0; i < matrix.length; i++) {
			Fraction newTerm= matrix[i][matrix.length].multiply(new Fraction(new Apint((long) Math.pow(n, i)), Apint.ONE));
			hundred = hundred.add(newTerm);
		}
		System.out.println("The value of the function at a hundred is " + hundred);
	}

}
