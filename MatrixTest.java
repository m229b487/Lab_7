import static org.junit.Assert.*;

import org.junit.Test;


public class MatrixTest {

	@Test
	public void testMatrix() {
		Matrix testmat = new Matrix(5);
		
		assertEquals(testmat.number == 5, true);
	}

	@Test
	public void testSetMData() {
		Matrix testmat2 = new Matrix(5);
		double[][] testarr = new double[5][5];
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				testarr[i][j] = i;
			}
		}
		testmat2.setMData(testarr);
		
		assertEquals(testmat2.data, testarr);
	}

	@Test
	public void testGetMDataAtI() {
		Matrix testmat3 = new Matrix(5);
		double[][] testarr = new double[5][5];
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				testarr[i][j] = i;
			}
		}
		testmat3.setMData(testarr);
		
		assertEquals(testmat3.getMDataAtI(0,0) == 0 && testmat3.getMDataAtI(4,4) == 4, true );
	}

	@Test
	public void testDeterminant() {
		Matrix newmat = new Matrix(3);
		double[][] testarr = new double[3][3];
				
				testarr[0][0] = 5;
				testarr[0][1] = 4;
				testarr[0][2] = 3;
				testarr[1][0] = 6;
				testarr[1][1] = 9;
				testarr[1][2] = 1;
				testarr[2][0] = 2;
				testarr[2][1] = 5;
				testarr[2][2] = 3;
				
				newmat.setMData(testarr);
				
				assertEquals(82.0, newmat.determinant(), 0.001);
	}

	@Test
	public void testInverse() {
		Matrix testmat4 = new Matrix(5);
		double[][] testarr = new double[5][5];
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				testarr[i][j] = i;
			}
		}
		testmat4.setMData(testarr);
		
		Matrix invmat = testmat4.inverse();
		
		assertEquals(invmat.getMDataAtI(0,0) , testmat4.getMDataAtI(5,5));
	}

	@Test
	public void testSubMatrix() {
		Matrix testmat5 = new Matrix(5);
		double[][] testarr = new double[5][5];
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				testarr[i][j] = i;
			}
		}
		testmat5.setMData(testarr);
		Matrix subTest = testmat5.subMatrix(4,4);
		
		
		assertEquals(subTest.getMDataAtI(4,4), testmat5.getMDataAtI(4,4));
	}

}
