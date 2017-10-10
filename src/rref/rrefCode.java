package rref;

public class rrefCode {
	
	public static double[][] rref(double[][] mat)
	{
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
