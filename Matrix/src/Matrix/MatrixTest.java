package Matrix;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatrixTest {

	@Test
	void test() {
		int testrijaantal = 2;
		int testkolomaantal = 4;
		double[] testlijst = new double[] {1, 2, 3, 4, 5, 6, 7, 8};
		double[] scaledlijst = new double[] {2, 4, 6, 8, 10, 12, 14, 16};
		Matrix testmatrix = new Matrix(testrijaantal, testkolomaantal, testlijst);
		assertEquals(2, testmatrix.getRowAmount());
		assertEquals(4, testmatrix.getColumnAmount());
		assertEquals(2, testmatrix.getElement(0,1), 0.0001);
		assertArrayEquals(new double[] {1, 2, 3, 4, 5, 6, 7, 8}, testmatrix.getArrayRowMajorOrder());
		assertArrayEquals(new double[] {1, 5, 2, 6, 3, 7, 4, 8}, testmatrix.getArrayColumnMajorOrder());
		assertArrayEquals(testmatrix.getArrayOfArrays(), new double[][] {{1, 2, 3, 4}, {5, 6, 7, 8}});
		Matrix testmatrix2 = new Matrix(testrijaantal, testkolomaantal, testlijst);
		assertArrayEquals((testmatrix.scaled(2)).getArrayRowMajorOrder(), scaledlijst);
		assertArrayEquals((testmatrix.plus(testmatrix2)).getArrayRowMajorOrder(), scaledlijst);		
	}

}
