/* 
The Gauss-Jordan elimination method differs from Gaussian
elimination in that the elements above the main diagonal of the coefficient ma-
trix are made zero at the same time and by the same use of a pivot row as the
elements below the main diagonal. Thus, the coefficient matrix is transformed
into a diagonal matrix rather than an upper-triangular matrix. Furthermore, if
each pivot row is “divided by” its pivot (leading non-zero entry) prior to its use
as a pivot row, the coefficient matrix is transformed into the identity matrix,
and the back substitution step may be dispensed with entirely. That is, the solu-
tion x is simply the last column of the (transformed) augmented system matrix.
Modify the BetterForwardElimination algorithm to perform Gauss-Jordan elim-
ination to solve a system of n linear equations in n unknowns with the form
Ax = b, where A is an n × n matrix of real coefficients2, and b is a column
vector with n real entries.
Implement your algorithm in Java to find the unique solution to the system:
x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9 + x10 = 2047
x0 + x1 = 3
x2 + x3 = 12
x4 + x5 = 48
x7 + x8 = 384
x9 + x10 = 1536
x0 + x2 = 5
x1 + x4 + x5 = 50
x5 + x7 + x8 + x9 + x10 = 1952
1x0 + 10x1 + 9x2 + 8x3 + 7x4 + 6x5 + 5x6 + 4x7 + 3x8 + 2x9 + x10 = 4083
1x0 − 10x1 + 9x2 − 8x3 + 7x4 − 6x5 + 5x6 − 4x7 + 3x8 − 2x9 + x10 = 459

1 1 1 1 1 1 1 1 1 1 1 2047
1 1 0 0 0 0 0 0 0 0 0 3
0 0 1 1 0 0 0 0 0 0 0 12
0 0 0 0 1 1 0 0 0 0 0 48
0 0 0 0 0 0 0 1 1 0 0 384
0 0 0 0 0 0 0 0 0 1 1 1536
1 0 1 0 0 0 0 0 0 0 0 5
0 1 0 0 1 1 0 0 0 0 0 50
0 0 0 0 0 1 0 1 1 1 1 1952
11 10 9 8 7 6 5 4 3 2 1 4083
11 -10 9 -8 7 -6 5 -4 3 -2 1 459
 */

public class gauss_jordan {
    public static float[] elim (float[][] A, float[]b ) {
        return b;

    }
    public static void main (String args[] ){
        float[][] A = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 
        {1, 1, 0, 0, 0, 0, 0 , 0, 0, 0, 0},
        {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
        {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1},
        {11, 10, 9, 8, 7 , 6, 5, 4, 3, 2, 1},
        {11, -10, 9, -8, 7, -6, 5, -4, 3, -2, 1}};

        float[] b = {2047, 3, 12, 48, 384, 1536, 5, 50, 1952, 4083, 459};

        float[] epic = elim(A, b);
        System.out.println(epic);


    }
}

