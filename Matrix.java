import java.io.*;
import static java.lang.Math.pow;

public class Matrix {

	private int maxsize;
	private int number;
	private double data[][] = new double[maxsize][maxsize]; 
	
	public Matrix(int n)
	{
		maxsize = n;
		number = n;
	}
	
	public void setMData(double[][] arr)
	{
		
	}
	
	public double getMDataAtI(int a, int b)
	{
		double result = data[a][b];
		return result;
	}
	
	public double determinant()
	{
		double det = 0.0;
		
		if (number == 1)
		{
			det = data[0][0];
		}
		else if (number == 2)
		{
			det = data[0][0] * data[1][1] - data[0][1] * data[1][0];
		}
		else
		{
			for (int i = 0; i < number; i++)
			{
				det += pow(-1.0, (double)i) * data[0][1] * subMatrix(0, i).determinant();
			}
		}
		
		return det;
	}
	
	public Matrix inverse()
	{
		Matrix inv = new Matrix(number);
		double det = determinant();
		
		for (int i = 0; i < number; ++i)
		{
			for (int j = 0; j < number; ++j)
			{
				inv.data[i][j] = pow(-1.0, (double)i + j) * subMatrix(j, i).determinant() / det;
			}
		}
		return inv;
	}
	
	public Matrix subMatrix(int r, int c)
	{
		Matrix sub = new Matrix(number - 1);
		
		int row = 0;
		for (int i = 0; i < number; ++i)
		{
			if (i==r) continue;
			
			int col = 0;
			for (int j = 0; j < number; ++j)
			{
				if (j == c) continue;
				
				sub.data[row][col] = data[i][j];
				++col;
			}
			
			++row;
		}
		return sub;
	}
}
