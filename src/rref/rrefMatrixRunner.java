package rref;

public class rrefMatrixRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 99;
		double[][] matrix = new double[n][n+1];
		for (int i = 1; i<=n; i++) {
			for (int j = 1; j<=n+1; j++) {
				if (j!=n+1) {
					matrix[i-1][j-1] = Math.pow(i, j);
				}
				else {
					matrix[i-1][j-1] = Math.pow(i, 2)+1;
				}
			}
		}
		matrix = rref(matrix);
// 		Print out matrix
		
//		for (int i = 0; i < matrix.length; i++) {
//		    for (int j = 0; j < matrix[i].length; j++) {
//		        System.out.print(matrix[i][j] + " ");
//		    }
//		    System.out.println();
//		}
		
//		Print out last column of rrefed matrix
//		for (int i = 0; i < matrix.length; i++) {
//		    System.out.print(matrix[i][matrix.length] + " ");
//		    System.out.println();
//		}
//		Print out f(100)
		double hundred=0;
		for (int i = 0; i < matrix.length; i++) {
			double newTerm= matrix[i][matrix.length]*Math.pow(14, i);
			hundred = hundred + newTerm;
		}
		System.out.println("The value of the function at a hundred is " + hundred);
	}
	
	public static double[][] rref(double[][] mat) {
		// TODO Auto-generated method stub
		double[][] rref = new double[mat.length][mat[0].length];

	    /* Copy matrix */
	    for (int r = 0; r < rref.length; ++r)
	    {
	        for (int c = 0; c < rref[r].length; ++c)
	        {
	            rref[r][c] = mat[r][c];
	        }
	    }

	    for (int p = 0; p < rref.length; ++p)
	    {
	        /* Make this pivot 1 */
	        double pv = rref[p][p];
	        if (pv != 0)
	        {
	            double pvInv = 1.0 / pv;
	            for (int i = 0; i < rref[p].length; ++i)
	            {
	                rref[p][i] *= pvInv;
	            }
	        }

	        /* Make other rows zero */
	        for (int r = 0; r < rref.length; ++r)
	        {
	            if (r != p)
	            {
	                double f = rref[r][p];
	                for (int i = 0; i < rref[r].length; ++i)
	                {
	                    rref[r][i] -= f * rref[p][i];
	                }
	            }
	        }
	    }
	    return rref;
	}

}
