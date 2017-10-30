package rref;

public class Matrix {
	
	private Fraction[][] matrix;
	
	public Matrix(Fraction[][] matrx) {
		this.matrix = matrx;
	}
	
	public void rref() {
		for (int i = 0; i<matrix[0].length-1; i++) {
			for (int j = 0; j<matrix.length; j++) {
				Fraction multiple = matrix[i][i].divide(matrix[j][i]);
				if (i<j) {
					multrowadd(multiple, i, j);
				} else if (i>j) {
					multrowaddneg(multiple, i, j);
				}
			}
		}
	}
	private void multrowadd(Fraction multiple, int row1, int row2) {
		for (int col = 0; col<matrix[0].length; col++) {
			matrix[row2][col]=matrix[row1][col].subtract(matrix[row2][col].multiply(multiple));
		}
	}
	private void multrowaddneg(Fraction multiple, int row1, int row2) {
		for (int col = 0; col<matrix[0].length; col++) {
			matrix[row1][col]=(matrix[row2][col].multiply(multiple)).subtract(matrix[row1][col]);
		}
	}
	public String toString() {
		String grid = "";
		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix[i].length; j++) {
		        grid += matrix[i][j] + " ";
		    }
		    grid += "\n";
		}
		return grid;
	}

}
