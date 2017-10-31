package rref;

public class Matrix {
	
	private Fraction[][] matrix;
	
	public Matrix(Fraction[][] matrx) {
		this.matrix = matrx;
	}
	
	public void rref() {
		for (int col = 0; col<matrix[0].length-1; col++) {
			for (int row = 0; row<matrix.length; row++) {
				Fraction multiple = new Fraction(1,1);
				if(matrix[row][col].equals(new Fraction(0,1))==false) {
					multiple = matrix[col][col].divide(matrix[row][col]);
				}
				if (col<row) {
					multrowadd(multiple, col, row);
				}
				else if (col>row) {
					multrowaddneg(multiple, col, row);
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
			matrix[row1][col]=(matrix[row1][col].multiply(multiple)).subtract(matrix[row2][col]);
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
