import java.util.Scanner;
import java.io.*;

public class Main
{

public static void main(String [] args )
{
	// Confirm command-line parameters
	if (args.length < 3)
	{
		System.out.println ("Error - Expected usage: ./main input.txt output.txt");
		return;
	}
	
	try
	{
	
	// Initialize file streams
	Scanner yourScanner = new Scanner(new File(args[1]));
	OutputStream ofile = new FileOutputStream(args[2]);
	PrintStream yourOut = new PrintStream(ofile);
	int a = yourScanner.nextInt();
	double [][] arr = new double[a][a];
	
	// Process commands
	int n;
	
	
	while (yourScanner.hasNextInt() && a > 0)
	{
		arr = new double [a][a];
		yourOut.println ("m = ");
		
		for(int i = 0; i < a; i++)
		{
			for(int j = 0; j < a; j++)
			{
				arr[i][j] = yourScanner.nextInt();
				yourOut.println((int)arr[i][j] + " ");
			}
		}
		
		Matrix m = new Matrix(a);
		m.setMData(arr);
		double determinant = m.determinant();
		
		yourOut.println("Determinant: " + determinant);
		
		if (determinant != 0)
		{
			Matrix inv = m.inverse();
			yourOut.println("Inverse: " + inv);
			
			for (int i = 0; i < a; ++i)
			{
				for (int j = 0; j < a; ++j)
				{
					 yourOut.println(inv.getMDataAtI(i, j) + " ");
				}
				yourOut.println();
			}
		}
		
		
	}
	}
	catch(Exception e)
	{
		
	}
	return;
}}


